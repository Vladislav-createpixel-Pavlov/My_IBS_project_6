package tests;

import basetestclass.BaseTests;
import managers.DriverManager;
import org.junit.Test;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.concurrent.TimeUnit;


//@RunWith(Parameterized.class)
public class FirstTest extends BaseTests{
   String value1 = "Kartofel_123)/.";

    protected BaseTests app = new BaseTests();

    @Test
    @Tag("Овощ")
    public void test_first(){
        System.out.println("Параметры:\nТестовое значение №1 = "+ value1);
        app.checkOpenPage();
        app.Click("Добавить");
        app.FillField("Наименование",value1);
        app.Click("Овощ");
        app.SaveClick();
        app.CheckResult(value1);
        System.out.println("Тест пройден");
    }


}
