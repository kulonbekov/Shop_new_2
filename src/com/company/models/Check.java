package com.company.models;

import java.util.Date;

public class Check {
    private Long id;
    private Employee employee;
    private double totalSum;
    private Long num;
    private int fd;

    private String add_date;

    public Check(Long id, Employee employee, double totalSum, Long num, int fd, String add_date) {
        this.id = id;
        this.employee = employee;
        this.totalSum = totalSum;
        this.num = num;
        this.fd = fd;
        this.add_date = add_date;
    }

    public Check() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public double getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(double totalSum) {
        this.totalSum = totalSum;
    }

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }

    public int getFd() {
        return fd;
    }

    public void setFd(int fd) {
        this.fd = fd;
    }

    public String getAdd_date() {
        return add_date;
    }

    public void setAdd_date(String add_date) {
        this.add_date = add_date;
    }

    @Override
    public String toString() {
        return "Check{" +
                "id=" + id +
                ", employee=" + employee +
                ", totalSum=" + totalSum +
                ", num=" + num +
                ", fd=" + fd +
                ", add_date='" + add_date + '\'' +
                '}';
    }
}
