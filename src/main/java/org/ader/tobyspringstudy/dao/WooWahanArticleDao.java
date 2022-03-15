package org.ader.tobyspringstudy.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class WooWahanArticleDao implements ConnectionMaker{
    @Override
    public Connection makeConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");
        Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/toby_spring", "sa", "");

        return conn;
    }
}
