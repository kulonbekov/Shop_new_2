package com.company.models;

public class CheckProduct {
    private Long id;
    private Product product;
    private Check check;
    private double cost;
    private double count;

    public CheckProduct(Long id, Product product, Check check, double cost, double count) {
        this.id = id;
        this.product = product;
        this.check = check;
        this.cost = cost;
        this.count = count;
    }

    public CheckProduct() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Check getCheck() {
        return check;
    }

    public void setCheck(Check check) {
        this.check = check;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getCount() {
        return count;
    }

    public void setCount(double count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "CheckProduct{" +
                "id=" + id +
                ", product=" + product +
                ", check=" + check +
                ", cost=" + cost +
                ", count=" + count +
                '}';
    }
}
