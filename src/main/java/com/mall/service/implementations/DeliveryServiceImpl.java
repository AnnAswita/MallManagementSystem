package com.mall.service.implementations;

import com.mall.model.Delivery;
import com.mall.repository.DeliveryFileRepository;
import com.mall.service.interfaces.IDeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DeliveryServiceImpl implements IDeliveryService{
	    @Autowired
	    private DeliveryFileRepository repo;

	    @Override
	    public Delivery createDelivery(String orderDetails, String destination) {
	        List<Delivery> list = repo.load();

	        Delivery d = new Delivery();
	        d.setDeliveryId(list.size() + 1);
	        d.setOrderDetails(orderDetails);
	        d.setDestination(destination);
	        d.setStatus("PENDING");

	        list.add(d);
	        repo.save(list);

	        return d;
	    }

	    @Override
	    public List<Delivery> getPendingDeliveries() {
	        return repo.load().stream()
	                .filter(d -> d.getStatus().equals("PENDING"))
	                .toList();
	    }

	    @Override
	    public Delivery assignDelivery(int deliveryId, int staffId) {
	        List<Delivery> list = repo.load();

	        for (Delivery d : list) {
	            if (d.getDeliveryId() == deliveryId) {
	                d.setAssignedStaffId(staffId);
	                d.setStatus("SCHEDULED");
	                repo.save(list);
	                return d;
	            }
	        }
	        return null;
	    }
	}
}
