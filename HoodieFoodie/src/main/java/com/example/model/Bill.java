package com.example.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;
@Entity
public class Bill {
    @Id
    private String billId;
    private LocalDateTime billDate;
    @ManyToOne
    @JoinColumn(name = "order_order_id")
    private OrderDetails order;
    private Integer totalItem;

    public Bill() {
    }

    public Bill(String billId, LocalDateTime billDate, OrderDetails order, Integer totalItem) {
        this.billId = billId;
        this.billDate = billDate;
        this.order = order;
        this.totalItem = totalItem;
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
