package com.company.services;

import com.company.models.Product;

import java.util.List;

public interface ProductService {

    void create(Product product);

    List<Product> getList();
    Product findById (long id);
    void updateShop (long id);
    void deleteShop(long id)
                ;
}
