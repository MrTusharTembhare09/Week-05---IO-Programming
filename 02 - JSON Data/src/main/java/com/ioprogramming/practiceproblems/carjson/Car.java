package com.ioprogramming.practiceproblems.carjson;

public class Car {
    private String brand;
    private String model;
    private int year;

    // Creating a constructor
    public Car(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    // Adding getters (Jackson requires getters for serialization)
    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }
}

