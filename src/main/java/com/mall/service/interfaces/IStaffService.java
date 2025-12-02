package com.mall.service.interfaces;

import com.mall.model.DeliveryStaff;
import java.util.List;

public interface IStaffService {
	List<DeliveryStaff> getAvailableStaff();
}
