package com.cookandroid.healthcareproject;

import java.io.Serializable;

public class User implements Serializable {
    private String name;
    private int age;
    private double height; // 단위: cm
    private double weight; // 단위: kg
    private String gender;

    public User(String name, int age, double height, double weight, String gender) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    // BMI 계산 메서드
    public double calculateBMI() {
        double heightInMeters = height / 100.0;
        return weight / (heightInMeters * heightInMeters);
    }

    // 체지방률 계산 메서드
    public double calculateBodyFatPercentage() {
        double bmi = calculateBMI();
        return gender.equalsIgnoreCase("male")
                ? (1.20 * bmi) + (0.23 * age) - 16.2
                : (1.20 * bmi) + (0.23 * age) - 5.4;
    }
}
