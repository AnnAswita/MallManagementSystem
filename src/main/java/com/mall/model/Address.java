/**
 * author : carolin.thomas
 */
package com.mall.model;

/**
 * 
 */
public class Address {
	
	    private Long addressId;
	    private String street;
	    private String city;
	    private String postalCode;
	    
		
		public Long getAddressId() {
			return addressId;
		}
		public void setAddressId(Long addressId) {
			this.addressId = addressId;
		}
		public String getStreet() {
			return street;
		}
		public void setStreet(String street) {
			this.street = street;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getPostalCode() {
			return postalCode;
		}
		public void setPostalCode(String postalCode) {
			this.postalCode = postalCode;
		}
	    
	    

}
