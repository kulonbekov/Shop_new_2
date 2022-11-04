package com.company.services.impl;

import com.company.db.DbHelper;
import com.company.db.impl.DbHelperImpl;
import com.company.models.Check;
import com.company.models.Employee;
import com.company.models.Product;
import com.company.services.CheckService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CheckServiceImpl implements CheckService {

    DbHelper dbHelper=new DbHelperImpl();
    @Override
    public String save(Check check) {

        try {
            PreparedStatement ps = dbHelper.getConnection("insert into tb_check (employee_id, add_date, num_of_check,total , fd) Values(?,?,?,?,?)");
            ps.setLong(1, check.getEmployee().getId());
            ps.setString(2, String.valueOf(new Date()));
            ps.setLong(3, check.getNum());
            ps.setDouble(4, check.getTotalSum());
            System.out.println(check.getTotalSum());
            ps.setLong(5, check.getFd());

            ps.executeUpdate();
            return String.valueOf(new Date());

        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Check> findList() {
        try{
            PreparedStatement ps = dbHelper.getConnection("select c.id,c.num_of_check, c.fd, c.totalSum, e.id " +
                    "as employee_id , e.name" +
                    "from tb_checks c " +
                    "e.id = c.employee.id;");
            ResultSet resultSet = ps.executeQuery();

            List<Check> checks = new ArrayList<>();
            while(resultSet.next()){
                Check check=new Check();
                check.setId(resultSet.getLong("id"));
                Employee employee=new Employee();
                employee.setName(resultSet.getString("name"));
                employee.setId(resultSet.getInt("employee_id"));
                check.setEmployee(employee);
                check.setFd(resultSet.getInt("fd"));
                check.setTotalSum(resultSet.getDouble("total"));
                check.setNum(resultSet.getLong("num_of_check"));
                checks.add(check);
            }
            return checks;

        }catch (Exception e){
            throw new RuntimeException("Ошибка при cохранении чека");
        }
    }

    @Override
    public Check findById(String check_add_date) {
        try {
            PreparedStatement ps=dbHelper.getConnection("Select * from tb_check Where add_date = ?" );
            ps.setString(1,check_add_date);
            ResultSet rs=ps.executeQuery();
            Check check=new Check();
            while(rs.next()){
                check.setId(rs.getLong("id"));

            }
            return check;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateSeller(long id, double total) {
        try {
            PreparedStatement ps = dbHelper.getConnection("Update tb_check set total=? where id=?");
            ps.setDouble(1,total);
            ps.setLong(2,id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
