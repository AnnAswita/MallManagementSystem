package com.mall.service.implementations;

import com.mall.model.DeliveryStaff;
import com.mall.model.Staff;
import com.mall.repository.DeliveryStaffRepository;
import com.mall.service.interfaces.IStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffServiceImpl implements IStaffService {

	@Autowired
    private DeliveryStaffRepository repo;

    @Override
    public List<DeliveryStaff> getAvailableStaff() {
    	 return repo.loadDeliveryStaff().stream()
    	            .filter(s -> s.getRole().equals("DELIVERY_STAFF"))
    	            .toList();
    }
}
