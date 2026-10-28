package com.vedant.cars.model;

import jakarta.persistence.*;

@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String brand;
    private String modelName;
    private String category;
    private String price;
    private String engine;
    private String power;
    private String acceleration;
    private String topSpeed;
    private String imageUrl;

    public Car() {
    }

    public Car(String brand, String modelName, String category, String price, 
               String engine, String power, String acceleration, String topSpeed, String imageUrl) {
        this.brand = brand;
        this.modelName = modelName;
        this.category = category;
        this.price = price;
        this.engine = engine;
        this.power = power;
        this.acceleration = acceleration;
        this.topSpeed = topSpeed;
        this.imageUrl = imageUrl;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }

    public String getModelName() { return modelName; }
    public void setModelName(String modelName) { this.modelName = modelName; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getPrice() { return price; }
    public void setPrice(String price) { this.price = price; }

    public String getEngine() { return engine; }
    public void setEngine(String engine) { this.engine = engine; }

    public String getPower() { return power; }
    public void setPower(String power) { this.power = power; }

    public String getAcceleration() { return acceleration; }
    public void setAcceleration(String acceleration) { this.acceleration = acceleration; }

    public String getTopSpeed() { return topSpeed; }
    public void setTopSpeed(String topSpeed) { this.topSpeed = topSpeed; }

    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
}
