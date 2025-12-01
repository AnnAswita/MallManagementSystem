package com.mall.entity;

import java.util.List;

public class Shop {

    private Long shopID;
    private double area;
    private double rent;
    private String tenantInfo;
    private List<Agreement> agreements;

    public Shop() {}

    public Shop(Long shopID, double area, double rent, String tenantInfo) {
        this.shopID = shopID;
        this.area = area;
        this.rent = rent;
        this.tenantInfo = tenantInfo;
    }

    public Long getShopID() {
        return shopID;
    }

    public void setShopID(Long shopID) {
        this.shopID = shopID;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getRent() {
        return rent;
    }

    public void setRent(double rent) {
        this.rent = rent;
    }

    public String getTenantInfo() {
        return tenantInfo;
    }

    public void setTenantInfo(String tenantInfo) {
        this.tenantInfo = tenantInfo;
    }

    public List<Agreement> getAgreements() {
        return agreements;
    }

    public void setAgreements(List<Agreement> agreements) {
        this.agreements = agreements;
    }
}
