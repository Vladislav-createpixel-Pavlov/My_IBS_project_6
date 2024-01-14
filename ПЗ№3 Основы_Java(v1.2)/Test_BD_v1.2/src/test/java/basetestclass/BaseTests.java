package basetestclass;

import managers.DriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

import static utils.BaseConst.BASE_URL;

public class BaseTests {
    @FindBy(xpath = "//button[@data-toggle='modal']")
    private WebElement putbtn;
    /**
     * Предвижу резонный вопрос: почему бы просто не написать @FindBy(id = name),
     * пробовал, выдаёт ошибку: Элемент не интерактивный,
     * хотя при поиске по странице - находит то, что нужно
     */
    @FindBy(xpath = "//input[@id='name']")
    private WebElement name;
    @FindBy(id = "type")
    private WebElement list;
    @FindBy(xpath="//option[@value='VEGETABLE']")
    private WebElement vegetable;
    @FindBy(id = "save")
    private WebElement savebtn;
    @FindBy(xpath = "//option[@value='FRUIT']")
    private WebElement fruit;
    @FindBy(id = "exotic")
    private WebElement exotic;
    @FindBy(xpath = "//h5")
    private WebElement title;
    /**
     *  В xpath я просто скопировал full xpath со страницы,
     *  понимаю,что так делать не нужно, но я пробовал по xpath = //tbody/tr[last()]/td[1],
     *  но он находит правильный элемент с текстом только в браузере, внутри теста - нет
     */
    @FindBy(xpath = "/html/body/div/div[2]/div/table/tbody/tr[5]/td[1]")
    private WebElement number;


    public void FillField(String nameField, String value){
        WebElement element = null;
        if(nameField == "Наименование") {
            FillinputField(name, value);
        }else
            Assert.fail("Поля с названием: "+ nameField +" несуществует на странице");
        }



    public void Click(String nameField){
            switch (nameField) {
                case "Добавить":
                    putbtn.click();
                    break;
//                case "Сохранить":
//                    savebtn.click();
//                    break;
                case "Овощ":
                    vegetable.click();
                    break;
                case "Фрукт":
                    fruit.click();
                    break;
                case "Экзотический":
                    list.click();
                    break;
                default:
                    Assert.fail("Поля с названием: "+ nameField +" несуществует на странице");
            }
        }


    public void FillinputField(WebElement el,String value){
        el.sendKeys(value);
    }

    public void SaveClick(){
        savebtn.click();

    }

    public void CheckResult(String val){
        Assert.assertEquals("Тестовые данные не прошли проверку",val,number.getText());

    }
    public void checkOpenPage(){

        Assert.assertEquals("Заголовок не соответствует странице","Список товаров",title.getText());
    }


    private final DriverManager driverManager = DriverManager.getDriverManager();

    @Before
    public void SetUp(){

        driverManager.getDriver().get(BASE_URL);
        driverManager.getDriver().manage().window().maximize();
        driverManager.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driverManager.getDriver().manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);

    }
    @After
    public void Quit(){

        driverManager.quitDriver();
    }

    public BaseTests() {
        PageFactory.initElements(driverManager.getDriver(), this);
    }
}
