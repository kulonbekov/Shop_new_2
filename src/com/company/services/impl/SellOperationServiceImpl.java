package com.company.services.impl;

import com.company.exception.EmployeeNotFoundExc;
import com.company.exception.ProductNotFoundExc;
import com.company.models.Check;
import com.company.models.CheckProduct;
import com.company.models.Employee;
import com.company.models.Product;
import com.company.services.*;


import javax.xml.crypto.Data;
import java.util.*;

public class SellOperationServiceImpl implements SellOperationService {

    ProductService productService=new ProductServiceImpl();
    EmployeeService employeeService = new EmployeeServiceImpl();

    CheckService checkService = new CheckServiceImpl();
    CheckProductService checkProductService = new CheckProductServiceImpl();

    Scanner sc = new Scanner(System.in);
    boolean flag = true;
    @Override
    public void sell() {
        System.out.println("Выберите продукты для продажи ");
        List<Product> products=productService.getList();

        System.out.println(products);

        CheckProduct checkProduct = new CheckProduct();
        Check check = new Check();
        double total = 0;

        Employee employee = null;
        try {
            employee = employeeService.findById(3);
        }catch (Exception e){
            throw new RuntimeException("призошло ошибка при выводе продавца по ID");

        }
        check.setEmployee(employee);
        check.setNum(((long)Math.random()*(100 -1))+1);
        check.setFd(1);


        Check check1;
        check1 = checkService.findById(checkService.save(check));


        while (flag){
            System.out.println("Введите id продукта ");
            Product product=null;

            try {
                product=productService.findById(sc.nextLong());
            }catch (ProductNotFoundExc e){
                System.out.println(e.getMessage());
                continue;
            }
            checkProduct.setProduct(product);
            System.out.println("Введите количество");
            checkProduct.setCount(sc.nextDouble());
            checkProduct.setCost(product.getPrice());
            total = total + (checkProduct.getCount() * product.getPrice());
            checkProduct.setCheck(check1);
            checkProductService.save(checkProduct);

            System.out.println("продолжить выбор продукта? 1 - да, 0 - выход");
            int choose = sc.nextInt();
            if(choose == 1){
                flag = true;
            }else if(choose == 0){
                flag = false;
            }
        }

        checkService.updateSeller(check1.getId(),total);

    }
}
