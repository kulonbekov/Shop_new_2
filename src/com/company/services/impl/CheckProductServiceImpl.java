package com.company.services.impl;

import com.company.db.DbHelper;
import com.company.db.impl.DbHelperImpl;
import com.company.models.CheckProduct;
import com.company.services.CheckProductService;

import java.sql.PreparedStatement;
import java.util.Date;
import java.util.List;

public class CheckProductServiceImpl implements CheckProductService {

    DbHelper dbHelper=new DbHelperImpl();
    @Override
    public void save(CheckProduct check) {
        try {
            PreparedStatement ps = dbHelper.getConnection("insert into tb_checks_products (product_id, check_id, count,cost) values (?,?,?,?)");
            ps.setLong(1,check.getProduct().getId());
            ps.setLong(2,check.getCheck().getId());
            ps.setDouble(3,check.getCount());
            ps.setDouble(4, check.getCost());

            ps.executeUpdate();

        }catch (Exception e){
            throw new RuntimeException(e);
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
