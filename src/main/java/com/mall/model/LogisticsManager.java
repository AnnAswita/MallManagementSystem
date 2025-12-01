package com.mall.model;

public class LogisticsManager extends Staff {
	public LogisticsManager(Long id, String name, String emailId) {
        this.staffId = id;
        this.name = name;
        this.role = "LOGISTICS_MANAGER";
        this.emailId = emailId;
    }
}
