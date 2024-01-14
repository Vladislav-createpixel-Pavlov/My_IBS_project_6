package Tests;

import BaseTest.BaseTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.*;
import java.util.Objects;

public class FirstTest extends BaseTest {
    Connection connection;
    Statement statement;

    public FirstTest() throws SQLException {
    }
    @Before
    public void SetUp() throws SQLException {
        connection = DriverManager.getConnection(
                "jdbc:h2:tcp://localhost:9092/mem:testdb",
                "user",
                "pass"
        );
        statement = connection.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_UPDATABLE);
    }
    @After
    public void Exit() throws SQLException{
        statement.executeUpdate(delete);// завершение теста
        connection.close();
    }
    @Test
    public void Start() throws SQLException {
        System.out.printf("Тестовые параметры: %nНазвание:Картофель %nТип:VEGETABLE %nЭкзотический:0 %n");
        ResultSet c = statement.executeQuery(count);
        c.first();
        int v = c.getInt("COUNT(FOOD_ID)");
        statement.executeUpdate(insert);
        ResultSet g = statement.executeQuery(count);
        g.first();
        int f = g.getInt("COUNT(FOOD_ID)");
        BaseTest.CheckNumber(v,f);// Проверка на добавление предмета
        ResultSet resultSet = statement.executeQuery(select);
        resultSet.last();
        String s = resultSet.getString("FOOD_NAME");
        BaseTest.CheckName(s);
    }
}


