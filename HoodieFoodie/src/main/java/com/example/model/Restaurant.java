package com.example.model;

import javax.persistence.*;
import java.util.List;
@Entity
public class Restaurant {
    @Id
    private String restaurantId;
    private String restaurantName;
    @ManyToOne
    @JoinColumn(name = "address_address_id")
    private Address address;
    @ManyToMany
    @JoinTable(name = "restaurantItem", joinColumns = @JoinColumn(name ="restaurant_id" ),inverseJoinColumns = @JoinColumn(name = "item_id"))
    private List<Item> itemList;
    private String managerName;
    private String contactNumber;

    public Restaurant() {
    }

    public Restaurant(String restaurantId, String restaurantName, Address address, List<Item> itemList, String managerName, String contactNumber) {
        this.restaurantId = restaurantId;
        this.restaurantName = restaurantName;
        this.address = address;
        this.itemList = itemList;
        this.managerName = managerName;
        this.contactNumber = contactNumber;
    }

    public String getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(String restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "restaurantId='" + restaurantId + '\'' +
                ", restaurantName='" + restaurantName + '\'' +
                ", address=" + address +
                ", itemList=" + itemList +
                ", managerName='" + managerName + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                '}';
    }
}
