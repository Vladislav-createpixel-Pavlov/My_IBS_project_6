import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Test_BD{

    private static WebDriver driver;
    @BeforeAll
    public static void SetUp(){

        driver = new ChromeDriver();

    }
    @Test
    void TestCase2(){
        driver.get("http://localhost:8080/food");
        WebElement btn2  = driver.findElement(By.xpath("//button[@data-toggle='modal']"));
        btn2.click();
        WebElement name2  = driver.findElement(By.id("name"));
        name2.sendKeys("Kartofel_123)/.");
        WebElement list2 = driver.findElement(By.id("type"));
        list2.click();
        WebElement vetget = driver.findElement(By.xpath("//option[@value='VEGETABLE']"));
        vetget.click();
        WebElement b_tn = driver.findElement(By.id("save"));
        b_tn.click();

    }


    @Test
    void TestCase1(){

        driver.get("http://localhost:8080/food");
        WebElement btn1  = driver.findElement(By.xpath("//button[@data-toggle='modal']"));
        btn1.click();
        WebElement name1  = driver.findElement(By.id("name"));
        name1.sendKeys("Манго*($#''%");
        WebElement list1 = driver.findElement(By.id("type"));
        list1.click();
        WebElement fruit = driver.findElement(By.xpath("//option[@value='FRUIT']"));
        fruit.click();
        WebElement exotic1 = driver.findElement(By.xpath("//input[@id='exotic']"));
        exotic1.click();
        WebElement btn_fruit = driver.findElement(By.id("save"));
        btn_fruit.click();
    }
}