package com.company.models;

public class Employee {
    private int id;
    private String name;
    private int age;
    private Shop shopId;
    private boolean active;

    public Employee() {
    }

    public Employee(String name) {
        this.name = name;
    }

    public Employee(int id, String name, int age,  Shop shopId, boolean active) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.shopId = shopId;
        this.active = true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Shop getShopId() {
        return shopId;
    }

    public void setShopId(Shop shopId) {
        this.shopId = shopId;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", shopId=" + shopId +
                ", active=" + active +
                '}';
    }
}
