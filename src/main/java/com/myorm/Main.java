package com.myorm;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    public static void main (String[] args) {

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=EFTest",
                                                                "sa",
                                                                "gushihao");

            CallableStatement s = connection.prepareCall("insert into Students values('江泽民', '女', 34, '上海市', '江蛤蟆')");

            s.execute();

            connection.close();

        } catch (ClassNotFoundException e) {
            System.out.println("驱动加载错误");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("数据库连接错误");
            e.printStackTrace();
        }

        System.out.println("你好，世界！");
    }
}
