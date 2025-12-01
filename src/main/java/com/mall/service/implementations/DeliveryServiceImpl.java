package com.mall.service.implementations;

import com.mall.model.Address;
import com.mall.model.Delivery;
import com.mall.model.DeliveryStaff;
import com.mall.model.Goods;
import com.mall.model.Item;
import com.mall.repository.AddressRepository;
import com.mall.repository.DeliveryFileRepository;
import com.mall.repository.DeliveryStaffRepository;
import com.mall.repository.GoodsRepository;
import com.mall.repository.ItemRepository;
import com.mall.service.interfaces.IDeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DeliveryServiceImpl implements IDeliveryService{
    

    @Autowired
    private DeliveryFileRepository deliveryRepo;

    @Autowired
    private DeliveryStaffRepository staffRepo;

    @Autowired
    private GoodsRepository goodsRepo;

    @Autowired
    private AddressRepository addressRepo;

    @Autowired
    private ItemRepository itemRepo;

    @Override
    public Delivery createDelivery(Long goodsId, Long addressId, List<Long> itemIds) {

        List<Delivery> deliveries = deliveryRepo.load();

        Delivery d = new Delivery();
        d.setDeliveryId((long) (deliveries.size() + 1));
        d.setStatus("PENDING");

        // map goods
        Goods goods = goodsRepo.loadGoods().stream()
                .filter(g -> g.getGoodsId() == goodsId)
                .findFirst()
                .orElse(null);
        d.setGoods(goods);

        // map address
        Address addr = addressRepo.loadAddresses().stream()
                .filter(a -> a.getAddressId() == addressId)
                .findFirst()
                .orElse(null);
        d.setAddress(addr);

        // map items
        List<Item> allItems = itemRepo.loadItems();
        List<Item> selectedItems = allItems.stream()
                .filter(i -> itemIds.contains(i.getItemId()))
                .toList();
        d.setItems(selectedItems);

        deliveries.add(d);
        deliveryRepo.save(deliveries);

        return d;
    }

    @Override
    public List<Delivery> getPendingDeliveries() {
        return deliveryRepo.load().stream()
                .filter(d -> "PENDING".equalsIgnoreCase(d.getStatus()))
                .toList();
    }



	@Override
	public Delivery assignDelivery(Long deliveryId, Long staffId) {
        List<Delivery> deliveries = deliveryRepo.load();
        List<DeliveryStaff> staffList = staffRepo.loadDeliveryStaff();

        DeliveryStaff staff = staffList.stream()
                .filter(s -> s.getStaffId() == staffId)
                .findFirst()
                .orElse(null);

        if (staff == null) return null;

        for (Delivery d : deliveries) {
            if (d.getDeliveryId().equals(deliveryId)) {
                d.setAssignedStaff(staff);
                d.setStatus("SCHEDULED");

                deliveryRepo.save(deliveries);
                return d;
            }
        }
        return null;
	}
}
