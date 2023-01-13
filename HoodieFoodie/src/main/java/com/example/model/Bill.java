package com.example.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDateTime;
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class Bill {
    @Id
    @GeneratedValue(generator = "UUID",strategy = GenerationType.IDENTITY)
    @GenericGenerator(
    name = "UUID",
    strategy = "org.hibernate.id.UUIDGenerator")
    @Column(updatable = false, nullable = false)
    private String billId;
    @PastOrPresent(message = "{bill.invalid}")
    private LocalDateTime billDate;


    @OneToOne(cascade = CascadeType.ALL)
   // @JoinColumn(name = "order_order_id")
    private OrderDetails order;
    @Min(value = 1,message = "item should be minimum 1")
    private Integer totalItem;
    @Min(value = 99,message = "total cost should be minimum 99 Rupees")
    private Double totalCost;

//    public Bill() {
//    }
//
//    public Bill(String billId, LocalDateTime billDate, OrderDetails order, Integer totalItem, Double totalCost) {
//        this.billId = billId;
//        this.billDate = billDate;
//        this.order = order;
//        this.totalItem = totalItem;
//        this.totalCost = totalCost;
//    }
//
//    public Double getTotalCost() {
//        return totalCost;
//    }
//
//    public void setTotalCost(Double totalCost) {
//        this.totalCost = totalCost;
//    }
//
//
//
//	public String getBillId() {
//        return billId;
//    }
//
//    public void setBillId(String billId) {
//        this.billId = billId;
//    }
//
//    public LocalDateTime getBillDate() {
//        return billDate;
//    }
//
//    public void setBillDate(LocalDateTime billDate) {
//        this.billDate = billDate;
//    }
//
//    public OrderDetails getOrder() {
//        return order;
//    }
//
//    public void setOrder(OrderDetails order) {
//        this.order = order;
//    }
//
//    public Integer getTotalItem() {
//        return totalItem;
//    }
//
//    public void setTotalItem(Integer totalItem) {
//        this.totalItem = totalItem;
//    }
//
//
//
//	@Override
//	public String toString() {
//		return "Bill [billId=" + billId + ", billDate=" + billDate + ", order=" + order + ", totalItem=" + totalItem
//				+ ", totalCost=" + totalCost + "]";
//	}

}
