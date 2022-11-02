package com.company.services.impl;

import com.company.db.DbHelper;
import com.company.db.impl.DbHelperImpl;
import com.company.models.Check;
import com.company.models.Employee;
import com.company.services.CheckService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CheckServiceImpl implements CheckService {

    DbHelper dbHelper=new DbHelperImpl();
    @Override
    public void save(Check check) {

        try {
            PreparedStatement ps = dbHelper.getConnection("insert into tb_checks " +
                    "(employee_id, num_of_check, totalSum, add_date, fd)" +
                    "Values(?,?,?,?,?");
            ps.setInt(1, check.getEmployee().getId());
            ps.setLong(2, check.getNum());
            ps.setDouble(3, check.getTotalSum());
            ps.setString(4, String.valueOf(new Date()));
            ps.setLong(5, check.getFd());
        }catch (Exception e){
            throw new RuntimeException("Ошибка при сохранения чека");
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
                check.setTotalSum(resultSet.getDouble("totalSum"));
                check.setNum(resultSet.getLong("num_of_check"));
                checks.add(check);
            }
            return checks;

        }catch (Exception e){
            throw new RuntimeException("Ошибка при cохранении чека");
        }
    }

    @Override
    public Check findById(Long id) {
        try {
            PreparedStatement preparedStatement=dbHelper.getConnection("select c.*, e.id as employee_id, e.name  " +
                    "from tb_checks c " +
                    "inner join tb_employees e on " +
                    "e.id=c.employee_id" +
                    " where c.id=?");
            preparedStatement.setLong(1,id);
            ResultSet resultSet=preparedStatement.executeQuery();
            Check check=new Check();

            while(resultSet.next()){

                Employee employee=new Employee();
                employee.setName(resultSet.getString("name"));
                employee.setId(resultSet.getInt("employee_id"));
                check.setEmployee(employee);
                check.setFd(resultSet.getInt("fd"));
                check.setTotalSum(resultSet.getDouble("totalSum"));

            }
            return check;

        }catch (Exception e){
            throw  new RuntimeException("Ошибка при сохранении чека");
        }
    }
}
