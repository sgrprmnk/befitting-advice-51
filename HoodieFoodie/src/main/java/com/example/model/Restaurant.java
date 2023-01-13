package com.example.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Restaurant {
    @Id
    @GeneratedValue(generator = "UUID",strategy = GenerationType.IDENTITY)
    @GenericGenerator(
    name = "UUID",
    strategy = "org.hibernate.id.UUIDGenerator")
    @Column(updatable = false, nullable = false)
    private String restaurantId;
    @Pattern(regexp="^[A-Z][a-z]*]", message = "{name.invalid}")
    private String restaurantName;

    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "address_address_id")
  //  @Embedded //1812
    private Address address;
    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
//    @JoinTable(name = "restaurantItem", joinColumns = @JoinColumn(name ="restaurant_id" ),inverseJoinColumns = @JoinColumn(name = "item_id"))
    private List<Item> itemList;
    @Pattern(regexp="^[A-Z][a-z]*]", message = "{name.invalid}")
    private String managerName;
    @Size(min = 10, max = 10,message = "It should be 10 digits")
    @Pattern(regexp="^[0-9]*]", message = "{name.invalid}")
    private String contactNumber;

//    public Restaurant() {
//    }
//
//    public Restaurant(String restaurantId, String restaurantName, Address address, List<Item> itemList, String managerName, String contactNumber) {
//        this.restaurantId = restaurantId;
//        this.restaurantName = restaurantName;
//        this.address = address;
//        this.itemList = itemList;
//        this.managerName = managerName;
//        this.contactNumber = contactNumber;
//    }
//
//    public String getRestaurantId() {
//        return restaurantId;
//    }
//
//    public void setRestaurantId(String restaurantId) {
//        this.restaurantId = restaurantId;
//    }
//
//    public String getRestaurantName() {
//        return restaurantName;
//    }
//
//    public void setRestaurantName(String restaurantName) {
//        this.restaurantName = restaurantName;
//    }
//
//    public Address getAddress() {
//        return address;
//    }
//
//    public void setAddress(Address address) {
//        this.address = address;
//    }
//
//    public List<Item> getItemList() {
//        return itemList;
//    }
//
//    public void setItemList(List<Item> itemList) {
//        this.itemList = itemList;
//    }
//
//    public String getManagerName() {
//        return managerName;
//    }
//
//    public void setManagerName(String managerName) {
//        this.managerName = managerName;
//    }
//
//    public String getContactNumber() {
//        return contactNumber;
//    }
//
//    public void setContactNumber(String contactNumber) {
//        this.contactNumber = contactNumber;
//    }

}
