package com.company;

import com.company.services.CrudOperationService;
import com.company.services.SellOperationService;
import com.company.services.impl.CrudOperationServiceImpl;
import com.company.services.impl.SellOperationServiceImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        CrudOperationService crudOperationService = new CrudOperationServiceImpl();
        SellOperationService sellOperationService = new SellOperationServiceImpl();

        System.out.println("Перейти в управление справочником 1");
        System.out.println("Перейти в управление продажами 0");

        switch (sc.nextInt()){
            case 1:
                crudOperationService.crudObjects();
                break;
            case 0:
                sellOperationService.sell();
        }
    }
}