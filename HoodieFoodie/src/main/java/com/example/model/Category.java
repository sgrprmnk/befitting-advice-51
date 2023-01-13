package com.example.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class Category {
    @Id
    @GeneratedValue(generator = "UUID",strategy = GenerationType.IDENTITY)
    @GenericGenerator(
    name = "UUID",
    strategy = "org.hibernate.id.UUIDGenerator")
    @Column(updatable = false, nullable = false)
    private String catId;

    private String categoryName;

//    public Category() {
//    }
//
//    public Category(String catId, String categoryName) {
//        this.catId = catId;
//        this.categoryName = categoryName;
//    }
//
//    public String getCatId() {
//        return catId;
//    }
//
//    public void setCatId(String catId) {
//        this.catId = catId;
//    }
//
//    public String getCategoryName() {
//        return categoryName;
//    }
//
//    public void setCategoryName(String categoryName) {
//        this.categoryName = categoryName;
//    }
//
//    @Override
//    public String toString() {
//        return "Category{" +
//                "catId='" + catId + '\'' +
//                ", categoryName='" + categoryName + '\'' +
//                '}';
//    }
}
