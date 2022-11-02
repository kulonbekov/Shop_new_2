package com.company.db.impl;

import com.company.db.DbHelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DbHelperImpl implements DbHelper {
    @Override
    public PreparedStatement getConnection(String sql) {
        try {
            Connection connection= DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Comp\\IdeaProjects\\проекты\\IdeaProjects\\SQL\\shopDBS.db");
            return connection.prepareStatement(sql);

        } catch (SQLException e) {
            throw new RuntimeException("Произошла ошибка при подключении к базе данных");
        }
    }
}
