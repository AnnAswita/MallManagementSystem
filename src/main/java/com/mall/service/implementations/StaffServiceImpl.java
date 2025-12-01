package com.mall.service.implementations;

import com.mall.model.Staff;
import com.mall.repository.StaffFileRepository;
import com.mall.service.interfaces.IStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffServiceImpl implements IStaffService {

	@Autowired
    private StaffFileRepository repo;

    @Override
    public List<Staff> getAvailableStaff() {
        return repo.load().stream()
                .filter(s -> s.getRole().equals("DELIVERY_STAFF"))
                .toList();
    }
}
