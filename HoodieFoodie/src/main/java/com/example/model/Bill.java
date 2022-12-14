package com.example.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
@Entity
public class Bill {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator")
    @Column(updatable = false, nullable = false)
    private String billId;
    private LocalDateTime billDate;


    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "order_order_id")
    private OrderDetails order;
    private Integer totalItem;
    private Double totalCost;
    public Bill() {
    }

    public Bill(String billId, LocalDateTime billDate, OrderDetails order, Integer totalItem, Double totalCost) {
        this.billId = billId;
        this.billDate = billDate;
        this.order = order;
        this.totalItem = totalItem;
        this.totalCost = totalCost;
    }

    public Double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public LocalDateTime getBillDate() {
        return billDate;
    }

    public void setBillDate(LocalDateTime billDate) {
        this.billDate = billDate;
    }

    public OrderDetails getOrder() {
        return order;
    }

    public void setOrder(OrderDetails order) {
        this.order = order;
    }

    public Integer getTotalItem() {
        return totalItem;
    }

    public void setTotalItem(Integer totalItem) {
        this.totalItem = totalItem;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "billId='" + billId + '\'' +
                ", billDate=" + billDate +
                ", order=" + order +
                ", totalItem=" + totalItem +
                '}';
    }
}
