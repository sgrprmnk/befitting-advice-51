package com.example.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class Address {
    @Id
    @GeneratedValue(generator = "UUID",strategy = GenerationType.IDENTITY)
    @GenericGenerator(
    name = "UUID",
    strategy = "org.hibernate.id.UUIDGenerator")
    @Column(updatable = false)
    private String addressId;
    @Pattern(regexp="^[A-Z][a-z]*]", message = "{name.invalid}")
    private String buildingName;
    @Pattern(regexp="^[A-Z][a-z][0-9]*]",message = "{name.invalid}")
    private String StreetNo;
    @Pattern(regexp="^[A-Z][a-z]*]", message = "{name.invalid}")
    private String area;
    @Pattern(regexp="^[A-Z][a-z]*]",message = "{name.invalid}")
    private String city;
    @Pattern(regexp="^[A-Z][a-z]*]",message = "{name.invalid}")
    private String state;
    @Pattern(regexp="^[A-Z][a-z]*]",message = "{name.invalid}")
    private String country;
    @Size(min = 6,max = 6)
    @Pattern(regexp="^[0-9]*]",message = "{pin.invalid}")
    private String pinCode;

//    public Address() {
//    }
//
//    public Address(String addressId, String buildingName, String streetNo, String area, String city, String state, String country, String pinCode) {
//        this.addressId = addressId;
//        this.buildingName = buildingName;
//        StreetNo = streetNo;
//        this.area = area;
//        this.city = city;
//        this.state = state;
//        this.country = country;
//        this.pinCode = pinCode;
//    }
//
//    public String getAddressId() {
//        return addressId;
//    }
//
//    public void setAddressId(String addressId) {
//        this.addressId = addressId;
//    }
//
//    public String getBuildingName() {
//        return buildingName;
//    }
//
//    public void setBuildingName(String buildingName) {
//        this.buildingName = buildingName;
//    }
//
//    public String getStreetNo() {
//        return StreetNo;
//    }
//
//    public void setStreetNo(String streetNo) {
//        StreetNo = streetNo;
//    }
//
//    public String getArea() {
//        return area;
//    }
//
//    public void setArea(String area) {
//        this.area = area;
//    }
//
//    public String getCity() {
//        return city;
//    }
//
//    public void setCity(String city) {
//        this.city = city;
//    }
//
//    public String getState() {
//        return state;
//    }
//
//    public void setState(String state) {
//        this.state = state;
//    }
//
//    public String getCountry() {
//        return country;
//    }
//
//    public void setCountry(String country) {
//        this.country = country;
//    }
//
//    public String getPinCode() {
//        return pinCode;
//    }
//
//    public void setPinCode(String pinCode) {
//        this.pinCode = pinCode;
//    }
//
//    @Override
//    public String toString() {
//        return "Address{" +
//                "addressId='" + addressId + '\'' +
//                ", buildingName='" + buildingName + '\'' +
//                ", StreetNo='" + StreetNo + '\'' +
//                ", area='" + area + '\'' +
//                ", city='" + city + '\'' +
//                ", state='" + state + '\'' +
//                ", country='" + country + '\'' +
//                ", pinCode='" + pinCode + '\'' +
//                '}';
//    }
}
