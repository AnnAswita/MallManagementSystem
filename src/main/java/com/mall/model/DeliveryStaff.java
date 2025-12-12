//Author Ann Aswita
package com.mall.model;

public class DeliveryStaff extends Staff {
	
	public DeliveryStaff(Long id, String name, String emailId) {
        this.staffId = id;
        this.name = name;
        this.role = "DELIVERY_STAFF";
        this.emailId = emailId;
    }
}
