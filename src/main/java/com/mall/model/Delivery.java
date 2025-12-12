/**
 * author : carolin.thomas
 */
package com.mall.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.mall.state.CancelledState;
import com.mall.state.DeliveredState;
import com.mall.state.DeliveryState;
import com.mall.state.InTransitState;
import com.mall.state.PendingState;
import com.mall.state.ScheduledState;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Delivery{
	
    private Long deliveryId;
    private String status;
    private String invoice;
    private String summary;
    private String type; // NORMAL, EXPRESS
    private double weightKg;
    private String sizeCategory; //SMALL, MEDIUM, LARGE
    private List<Item> items;
    private DeliveryStaff assignedStaff;
    private Address address;
    private Goods goods;
    
    @JsonIgnore
    private DeliveryState state;

	
	public DeliveryStaff getAssignedStaff() {
		return assignedStaff;
	}
	public void setAssignedStaff(DeliveryStaff assignedStaff) {
		this.assignedStaff = assignedStaff;
	}
	public Long getDeliveryId() {
		return deliveryId;
	}
	public void setDeliveryId(Long deliveryId) {
		this.deliveryId = deliveryId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getInvoice() {
		return invoice;
	}
	public void setInvoice(String invoice) {
		this.invoice = invoice;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}

	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
    
    public DeliveryState getState() {
        return state;
    }

    public void setState(DeliveryState state) {
        this.state = state;
        this.status = state.getStatus();
    }
    
    public void setType(String type) {
    	this.type = type;
    }
    public String getType() {
    	return type;
    }
    public void setWeight(double weightKg) {
    	this.weightKg = weightKg;
    }
    public double getWeight() {
    	return weightKg;
    }
    public void setSizeCategory(String sizeCategory) {
    	this.sizeCategory = sizeCategory;
    }
    public String getSizeCategory() {
    	return sizeCategory;
    }
    
    public void schedule() {
        state.schedule(this);
    }

    public void startDelivery() {
        state.startDelivery(this);
    }

    public void completeDelivery() {
        state.completeDelivery(this);
    }

    public void cancel() {
        state.cancel(this);
    }

    public void restoreStateFromStatus() {
        if (this.status == null) {
            this.state = new PendingState();
            return;
        }

        switch (this.status) {
            case "PENDING" -> this.state = new PendingState();
            case "SCHEDULED" -> this.state = new ScheduledState();
            case "IN_TRANSIT" -> this.state = new InTransitState();
            case "DELIVERED" -> this.state = new DeliveredState();
            case "CANCELLED" -> this.state = new CancelledState();
            default -> this.state = new PendingState();
        }
    }

}
