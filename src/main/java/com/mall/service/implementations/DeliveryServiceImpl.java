package com.mall.service.implementations;

import com.mall.factory.DeliveryFactory;
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
import com.mall.state.ScheduledState;

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
        Long newId = (long) (deliveries.size() + 1);

        // Load Goods
        Goods goods = goodsRepo.loadGoods().stream()
                .filter(g -> g.getGoodsId().equals(goodsId))
                .findFirst()
                .orElse(null);

        // Load Address
        Address address = addressRepo.loadAddresses().stream()
                .filter(a -> a.getAddressId().equals(addressId))
                .findFirst()
                .orElse(null);

        // Load Items
        List<Item> allItems = itemRepo.loadItems();
        List<Item> selectedItems = allItems.stream()
                .filter(i -> itemIds.contains(i.getItemId()))
                .toList();

        // FACTORY PATTERN
        Delivery d = DeliveryFactory.createDelivery(
                newId,
                goods,
                address,
                selectedItems
        );

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
                
                //STATE PATTERN
                d.setState(new ScheduledState());

                deliveryRepo.save(deliveries);
                return d;
            }
        }
        return null;
	}
	
	@Override
	public Delivery updateStatus(Long deliveryId) {
	    List<Delivery> list = deliveryRepo.load();

	    for (Delivery d : list) {
	        if (d.getDeliveryId().equals(deliveryId)) {
	        	
	        	//Move to next State
	            d.getState().next(d);
	            deliveryRepo.save(list);
	            return d;
	        }
	    }
	    return null;
	}

}
