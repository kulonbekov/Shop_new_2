package com.company.services.impl;

import com.company.exception.ProductNotFoundExc;
import com.company.models.Check;
import com.company.models.CheckProduct;
import com.company.models.Product;
import com.company.services.ProductService;
import com.company.services.SellOperationService;

import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class SellOperationServiceImpl implements SellOperationService {

    ProductService productService=new ProductServiceImpl();
    TreeSet<Product> selectedProduct=new TreeSet<>();
    Scanner sc = new Scanner(System.in);
    boolean flag = true;
    @Override
    public void sell() {
        System.out.println("Выберите продукты для продажи ");
        List<Product> products=productService.getList();
        System.out.println(products);

        CheckProduct checkProduct = new CheckProduct();

        //save CheckProduct
        //save check

        while (flag){
            System.out.println("Введите id продукта ");
            Product product=null;
            Check check = null;
            try {
                product=productService.findById(sc.nextLong());
            }catch (ProductNotFoundExc e){
                System.out.println(e.getMessage());
                continue;
            }
            checkProduct.setId(((long)Math.random()*(100 -1))+1);
            checkProduct.setProduct(product);

            System.out.println("Введите количество");
            checkProduct.setCount(sc.nextDouble());
            checkProduct.setCost(product.getPrice());

            System.out.println("продолжить выбор продукта? 1 - да, 0 - выход");
            int choose = sc.nextInt();
            if(choose == 1){
                flag = true;
            }else if(choose == 0){
                flag = false;
            }
        }
        System.out.println(checkProduct);
 /*
        Вывести продукты для продажи
        Выбрать продукты ( Составить уникальный список продуктов для корзины и определять их количество )
        Создать Чек
           Крад чека
           Подсчет стоимости всех продуктов с учетом количества

           Вывод чека со стоимостью, списком продуктов, продавцом совершимшим операцию, магазином, где была произведена операция

        *
        * */
    }
}
