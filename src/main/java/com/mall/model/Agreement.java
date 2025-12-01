package com.mall.model;
import lombok.Data;

@Data
public class Agreement {

    private Long id;
    private double rentAmount;
    private String duration;
    private double deposit;
    private String conditions;
    private Long shopId; 

    public Agreement() {}

    public Agreement(Long id, double rentAmount, String duration, double deposit, String conditions, Long shopId) {
        this.id = id;
        this.rentAmount = rentAmount;
        this.duration = duration;
        this.deposit = deposit;
        this.conditions = conditions;
        this.shopId = shopId;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public double getRentAmount() { return rentAmount; }
    public void setRentAmount(double rentAmount) { this.rentAmount = rentAmount; }

    public String getDuration() { return duration; }
    public void setDuration(String duration) { this.duration = duration; }

    public double getDeposit() { return deposit; }
    public void setDeposit(double deposit) { this.deposit = deposit; }

    public String getConditions() { return conditions; }
    public void setConditions(String conditions) { this.conditions = conditions; }

    public Long getShopId() { return shopId; }
    public void setShopId(Long shopId) { this.shopId = shopId; }
}
