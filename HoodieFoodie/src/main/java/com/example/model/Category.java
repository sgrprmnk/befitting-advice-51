package com.example.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Category {
    @Id
    private String catId;
    private String categoryName;

    public Category() {
    }

    public Category(String catId, String categoryName) {
        this.catId = catId;
        this.categoryName = categoryName;
    }

    public String getCatId() {
        return catId;
    }

    public void setCatId(String catId) {
        this.catId = catId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "Category{" +
                "catId='" + catId + '\'' +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}
