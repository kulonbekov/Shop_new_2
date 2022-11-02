package com.company.db;

import java.sql.PreparedStatement;

public interface DbHelper {
    PreparedStatement getConnection(String sql);
}
