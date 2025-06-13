package com.example.dogfoodapp;

import java.io.Serializable;

public class Product implements Serializable {
    private int id;
    private String name;
    private String description;
    private double price;
    private String category;
    private String brand;
    private String age;
    private int imageResourceId; // Resource ID for product image

    public Product(int id, String name, String description, double price, String category, String brand, String age, int imageResourceId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.brand = brand;
        this.age = age;
        this.imageResourceId = imageResourceId;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public double getPrice() { return price; }
    public String getCategory() { return category; }
    public String getBrand() { return brand; }
    public String getAge() { return age; }
    public int getImageResourceId() { return imageResourceId; }
}
