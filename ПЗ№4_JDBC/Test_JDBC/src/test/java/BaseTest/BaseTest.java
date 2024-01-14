package BaseTest;

import java.sql.*;
import java.util.Objects;

/**
 * Константы и методы, нужные для теста
 */
public class BaseTest {
    protected String select = "SELECT * FROM FOOD";
    protected String count = "SELECT COUNT(FOOD_ID) FROM FOOD";
    protected String insert = "INSERT INTO FOOD(FOOD_NAME,FOOD_TYPE,FOOD_EXOTIC) VALUES ('Картофель','VEGETABLE',0)";
    protected String delete = "DELETE FROM FOOD WHERE FOOD_ID = (SELECT MAX(FOOD_ID) FROM FOOD)";

    public static void CheckNumber(int a,int b){
        if(Math.max(a,b)-Math.min(a,b) == 1){
            System.out.println("Добавление прошло успешно");
        }
    }
    public static void CheckName(String str){
        if(Objects.equals(str, "Картофель")){
        System.out.println("Тест пройден");
    }  }

}
