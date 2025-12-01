package com.mall.service.interfaces;

import com.mall.model.DeliveryStaff;
import com.mall.model.Staff;
import java.util.List;

public interface IStaffService {
	List<DeliveryStaff> getAvailableStaff();
}
