package com.zahidio;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Laptop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String brand;

    @Column
    private String model;

    @Column
    private String memory;

    @ManyToMany
    private List<Alien> alien;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public List<Alien> getAlien() {
        return alien;
    }

    public void setAlien(List<Alien> alien) {
        this.alien = alien;
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