package com.company.services.impl;

import com.company.db.DbHelper;
import com.company.db.impl.DbHelperImpl;
import com.company.models.CheckProduct;
import com.company.services.CheckProductService;

import java.sql.PreparedStatement;
import java.util.List;

public class CheckProductServiceImpl implements CheckProductService {

    DbHelper dbHelper=new DbHelperImpl();
    @Override
    public void save(CheckProduct check) {
        try {
            PreparedStatement preparedStatement=dbHelper.getConnection("insert into tb_checks_products (product_id, check_id, count,cost) " +
                    "values (?,?,?,?);");
            preparedStatement.setLong(1,check.getProduct().getId());
            preparedStatement.setLong(2,check.getCheck().getId());
            preparedStatement.setDouble(3,check.getCount());
            preparedStatement.setDouble(4, check.getCost());

        }catch (Exception e){
            throw  new RuntimeException("Ошибка при сохранении чека");
        }
    }

    @Override
    public List<CheckProduct> findList() {

        return null;
    }

    @Override
    public CheckProduct findById(Long id) {
        return null;
    }


}
