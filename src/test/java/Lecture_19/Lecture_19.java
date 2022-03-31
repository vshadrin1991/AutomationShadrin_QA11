package Lecture_19;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Lecture_19 {
    Connection connect;
    Statement statement;

    @BeforeTest
    public void preconditions() {
        try {
            connect = DriverManager.getConnection("jdbc:mysql://db4free.net/testqa11?user=testqa11&password=testqa11");
            statement = connect.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 1)
    public void select_test() throws Exception {
        System.out.println(select("select * from user where id = 1"));
    }

    @Test(priority = 2)
    public void update_test() throws Exception {
        System.out.println(update("update user set age = 100 where id = 1"));
        System.out.println(select("select * from user where id = 1"));
        System.out.println(update("update user set age = 20 where id = 1"));
    }

    @Test(priority = 3)
    public void insert_test() throws Exception {
        System.out.println(insert("insert into pet (id, name, type) values (2, 'Jack', 'Street')"));
        System.out.println(select("select * from pet"));
    }

    @Test(priority = 4)
    public void delete_test() throws Exception {
        System.out.println(delete("delete from pet where id = 2"));
        System.out.println(select("select * from pet"));
    }

    @AfterTest(alwaysRun = true)
    public void postconditions() {
        try {
            connect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int update(String query) {
        try {
            return statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int insert(String query) {
        try {
            return statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int delete(String query) {
        try {
            return statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public List<List<String>> select(String query) throws Exception {
        ResultSet resultSet = statement.executeQuery(query);
        List<List<String>> data = new ArrayList<>();
        while (resultSet.next()) {
            List<String> row = new ArrayList<>();
            for (int index = 1; index <= resultSet.getMetaData().getColumnCount(); index++) {
                row.add(resultSet.getString(index));
            }
            data.add(row);
        }
        return data;
    }
}
