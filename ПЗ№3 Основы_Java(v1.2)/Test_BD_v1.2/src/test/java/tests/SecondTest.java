package tests;

import basetestclass.BaseTests;
import org.junit.Test;
import org.junit.jupiter.api.Tag;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


public class SecondTest extends BaseTests {

    String value2 = "Манго*($#''%";
    protected BaseTests app = new BaseTests();

    @Test
    @Tag("Фрукт")
    public void test_first(){
        System.out.println("Параметры:\nТестовое значение №2 = "+ value2);
        app.checkOpenPage();
        app.Click("Добавить");
        app.FillField("Наименование",value2);
        app.Click("Фрукт");
        app.Click("Экзотический");
        app.SaveClick();
        app.CheckResult(value2);
        System.out.println("Тест пройден");
    }
}
