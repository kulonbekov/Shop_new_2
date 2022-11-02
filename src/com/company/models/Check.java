package com.company.models;

public class Check {
    private Long id;
    private Employee employee;
    private double totalSum;
    private Long num;
    private int fd;

    public Check(Long id, Employee employee, double totalSum, Long num, int fd) {
        this.id = id;
        this.employee = employee;
        this.totalSum = totalSum;
        this.num = num;
        this.fd = fd;
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
}
