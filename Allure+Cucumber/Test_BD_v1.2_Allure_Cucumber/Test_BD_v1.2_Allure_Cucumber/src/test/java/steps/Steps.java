package steps;

import basetestclass.BaseTests;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.ru.Допустим;
import io.cucumber.java.ru.И;
import managers.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



import java.util.concurrent.TimeUnit;

import static utils.BaseConst.BASE_URL;

public class Steps {

    protected BaseTests app = new BaseTests();
    @И("открыта страница по адресу {string}")
    public void открыта_страница_по_адресу(String string) {
        final DriverManager driverManager = DriverManager.getDriverManager();

        driverManager.getDriver().get(BASE_URL);
        driverManager.getDriver().manage().window().maximize();
        driverManager.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driverManager.getDriver().manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
    }

    @И("выполнено нажатие на {string}")
    public void выполнено_нажатие_на_Добавить(String string) {
        app.Click(string);
    }


    @И("поле {string} заполняется значением {string}")
    public void поле_заполняется_значением(String string,String string2) {
        app.FillField(string,string2);

    }

    @И("выпадающее меню Тип выбирается тип Овощ")
    public void выпадающее_меню_Тип_выбирается_тип_овощ() {
        app.VegClick();
    }
    @И("выпадающее меню Тип выбирается тип Фрукт")
    public void выпадающее_меню_Тип_выбирается_тип_Фрукт() {
        app.FruitClick();
    }
    @И("валидация страницы {string}")
    public void валидация_страницы(String string) {
        app.checkOpenPage();
    }
    @И("Проверка результата добавления {string}")
    public void Проверка_результата_добавления (String string) {
        app.CheckResult(string);
    }
    @И("выполнено нажатие на Сохранить")
    public void выполнено_нажатие_на_Сохранить() {
        app.SaveClick();
    }

    @И("активируется чекбокс {string}")
    public void активируется_чекбокс(String string) {
        app.Click(string);
    }
    @И("выполнено закрыть страницу")
    public void выполнено_закрыть_страницу() {
        app.Quit();
    }
}
