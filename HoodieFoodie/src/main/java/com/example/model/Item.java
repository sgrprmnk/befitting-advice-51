package com.example.model;

import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import java.util.List;
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Item {
    @Id
    @GeneratedValue(generator = "UUID",strategy = GenerationType.IDENTITY)
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator")
    @Column(updatable = false, nullable = false)
    private String itemId;
    @Pattern(regexp="^[A-Z][a-z]*]", message = "{name.invalid}")
    private String itemName;
    @ManyToOne(cascade = CascadeType.ALL)

//    @JoinColumn(name = "category_cat_id")
    private Category category;
    @Min(value = 1 ,message = "Minimum 1 should be there")
    private Integer quantity;
    @Min(value = 99,message = "Minimum cost should be 99 Rupees")
    private Double cost;

@ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL,mappedBy = "itemList")
    private List<Restaurant> restaurants;

//    public Item() {
//    }
//
//    public Item(String itemId, String itemName, Category category, Integer quantity, Double cost, List<Restaurant> restaurants) {
//        this.itemId = itemId;
//        this.itemName = itemName;
//        this.category = category;
//        this.quantity = quantity;
//        this.cost = cost;
//        this.restaurants = restaurants;
//    }
//
//    public String getItemId() {
//        return itemId;
//    }
//
//    public void setItemId(String itemId) {
//        this.itemId = itemId;
//    }
//
//    public String getItemName() {
//        return itemName;
//    }
//
//    public void setItemName(String itemName) {
//        this.itemName = itemName;
//    }
//
//    public Category getCategory() {
//        return category;
//    }
//
//    public void setCategory(Category category) {
//        this.category = category;
//    }
//
//    public Integer getQuantity() {
//        return quantity;
//    }
//
//    public void setQuantity(Integer quantity) {
//        this.quantity = quantity;
//    }
//
//    public Double getCost() {
//        return cost;
//    }
//
//    public void setCost(Double cost) {
//        this.cost = cost;
//    }
//
//    public List<Restaurant> getRestaurants() {
//        return restaurants;
//    }
//
//    public void setRestaurants(List<Restaurant> restaurants) {
//        this.restaurants = restaurants;
//    }


}
