package com.company.services.impl;

import com.company.models.Employee;
import com.company.models.Shop;
import com.company.services.CrudOperationService;
import com.company.services.EmployeeService;
import com.company.services.ProductService;
import com.company.services.ShopService;

import java.util.Scanner;

public class CrudOperationServiceImpl implements CrudOperationService {

    EmployeeService employeeService = new EmployeeServiceImpl();
    ShopService shopService = new ShopServiceImpl();
    ProductService productService = new ProductServiceImpl();
    @Override
    public void crudObjects() {

        Scanner sc = new Scanner(System.in);

        System.out.println("Выберите объект с которым хотите совершить операции.\n1-магазин ,2-продавец, 3-продукты");
        int answer = sc.nextInt();
        if (answer == 1) {
            System.out.println("Выберите операцию.\n" +
                    "Создать магазин - 1 \n" + "Получить список магазинов - 2 \n" +
                    "Изменить название магазина - 3 \n" +
                    "Удалить магазин - 4");
            int chooseOperation = sc.nextInt();
            switch (chooseOperation) {
                case 1:
                    System.out.println("Введите название магазина.");
                    String shopName = sc.next();
                    Shop shop = new Shop(shopName);
                    shopService.createShop(shop);
                    System.out.println("Вы успешно создали магазин с названием " + shopName);
                    break;
                case 2:
                    System.out.println("\n Список магазинов");
                    System.out.println(shopService.shopList());
                    break;
                case 3:
                    System.out.println("\n Введите название");
                    shopService.updateShop(1);
                    break;
                case 4:
                    shopService.deleteShop(1);
                    System.out.println("Объект 1 удален");
                    break;

            }
        } else if (answer == 2) {
            System.out.println("Выберите операцию.\n" +
                    "Создать продавца - 1 \n" + "Получить список продавцов - 2 \n" +
                    "Изменить имя прдодавца- 3 \n" +
                    "Удалить продавца - 4");
            int chooseOperation1 = sc.nextInt();
            switch (chooseOperation1) {
                case 1:
                    System.out.println("Введите имя продавца.");
                    String sellerName = sc.next();
                    System.out.println("Введите возраст продавца.");
                    int age = sc.nextInt();
                    System.out.println("Введите id Магазина");

                    System.out.println(shopService.shopList());

                    int shopId = sc.nextInt();

                    Employee emp = new Employee();
                    emp.setName(sellerName);
                    emp.setAge(age);
                    Shop shop=new Shop();
                    shop.setId(shopId);
                    emp.setShopId(shop);
                    employeeService.createSeller(emp);
                    System.out.println("Вы успешно создали продавца с именем " + sellerName);
                    break;
                case 2:
                    System.out.println("\n Список продавцов");
                    System.out.println(employeeService.empList());
                    break;
                case 3:
                    System.out.println("\n Введите имя");
                    employeeService.updateSeller(1);
                    break;
                case 4:
                    employeeService.deleteSeller(1);
                    System.out.println("Продавец 1 удален");
                    break;

            }

        }
        else if (answer == 3) {
            System.out.println("Выберите операцию.\n" +
                    "Создать продукта - 1 \n" + "Получить список продуктов - 2 \n" +
                    "Изменить продукта- 3 \n" +
                    "Удалить продукт - 4");
            int chooseOperation2 = sc.nextInt();
            switch (chooseOperation2) {
                case 1:
                    break;
                case 2:
                    System.out.println("\n Список продуктов");
                    System.out.println(productService.getList());
                    break;
            }
        }
    }
}
