package com.zahidio;

import jakarta.persistence.*;

@Embeddable
public class Laptop {
    @Column
    private String brand;

    @Column
    private String model;

    @Column
    private String memory;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", memory='" + memory + '\'' +
                '}';
    }
}