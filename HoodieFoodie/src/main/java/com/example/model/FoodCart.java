package com.example.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
@Entity
public class FoodCart {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator")
    @Column(updatable = false, nullable = false)
    private String cartId;
    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "customer_customer_id")
    private Customer customer;
    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "item_cart_id")
    private List<Item> itemList;

    public FoodCart() {
    }

    public FoodCart(String cartId, Customer customer, List<Item> itemList) {
        this.cartId = cartId;
        this.customer = customer;
        this.itemList = itemList;
    }

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    @Override
    public String toString() {
        return "FoodCart{" +
                "cartId='" + cartId + '\'' +
                ", customer=" + customer +
                ", itemList=" + itemList +
                '}';
    }
}
