package com.company.services.impl;

import com.company.db.DbHelper;
import com.company.db.impl.DbHelperImpl;
import com.company.models.Product;
import com.company.services.ProductService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService {

    DbHelper dbHelper=new DbHelperImpl();
    @Override
    public void create(Product product) {
        PreparedStatement ps=null;
        try {
            ps=dbHelper.getConnection("insert into tb_products (name,price) values (?,?)");
            ps.setString(1,product.getName());
            ps.setDouble(2,product.getPrice());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Product> getList() {

        try {
            PreparedStatement ps=dbHelper.getConnection("select * from tb_products");
            ResultSet rs=ps.executeQuery();
            List<Product>list=new ArrayList<>();
            while(rs.next()){
                Product product=new Product();
                product.setId(rs.getLong("id"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getDouble("price"));
                list.add(product);
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Product findById(long id) {

        try {
            PreparedStatement ps=dbHelper.getConnection("select * from tb_products where id=?");
            ps.setLong(1,id);
            ResultSet rs=ps.executeQuery();
            Product product=new Product();
            while(rs.next()){
                product.setId(rs.getLong("id"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getDouble("price"));
            }
            return product;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateShop(long id) {

    }

    @Override
    public void deleteShop(long id) {

    }
}
