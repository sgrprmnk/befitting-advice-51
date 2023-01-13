package com.example.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Min;
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
public class Customer {
    @Id
    @GeneratedValue(generator = "UUID",strategy = GenerationType.IDENTITY)
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator")
    @Column(updatable = false)
    private String customerId;
    @Pattern(regexp="^[A-Z][a-z][0-9]*]",message = "{name.invalid}")
    private String firstName;
    @Pattern(regexp="^[A-Z][a-z][0-9]*]",message = "{name.invalid}")
    private String lastName;
    @Min(value = 12,message = "minimum age should be 12")
    private Integer age;
    private String gender;
    @Size(min = 10, max = 10,message = "Mobile Number should be 10 digit")
    @Pattern(regexp="^[0-9]*]")
    private String mobileNumber;
 @OneToOne (cascade = CascadeType.ALL)
//    @JoinColumn(name = "address_address_id")
   // @Embedded ///1812
    private Address address;



    private String email;
    @Size(min=6, max=12)
    @Pattern(regexp="(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*\\W).*$",message = "Password should be minimum of 6 and maximum of 12 length, One Alphabet, One UpperCase, One Special character, One digit from 0 to 9")
    private String password;

//    public Customer() {
//    }
//
//    public Customer(String customerId, String firstName, String lastName, Integer age, String gender, String mobileNumber, Address address, String email, String password) {
//        this.customerId = customerId;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.age = age;
//        this.gender = gender;
//        this.mobileNumber = mobileNumber;
//        this.address = address;
//        this.email = email;
//        this.password = password;
//    }
//
//    public String getCustomerId() {
//        return customerId;
//    }
//
//    public void setCustomerId(String customerId) {
//        this.customerId = customerId;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public Integer getAge() {
//        return age;
//    }
//
//    public void setAge(Integer age) {
//        this.age = age;
//    }
//
//    public String getGender() {
//        return gender;
//    }
//
//    public void setGender(String gender) {
//        this.gender = gender;
//    }
//
//    public String getMobileNumber() {
//        return mobileNumber;
//    }
//
//    public void setMobileNumber(String mobileNumber) {
//        this.mobileNumber = mobileNumber;
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
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    @Override
//    public String toString() {
//        return "Customer{" +
//                "customerId='" + customerId + '\'' +
//                ", firstName='" + firstName + '\'' +
//                ", lastName='" + lastName + '\'' +
//                ", age=" + age +
//                ", gender='" + gender + '\'' +
//                ", mobileNumber='" + mobileNumber + '\'' +
//                ", address=" + address +
//                ", email='" + email + '\'' +
//                ", password='" + password + '\'' +
//                '}';
//    }
}
