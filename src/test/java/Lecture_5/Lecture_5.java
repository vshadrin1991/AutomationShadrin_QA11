package Lecture_5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Lecture_5 {
    WebDriver driver = null;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
    }

    /*
    Открыть сайт http://13gp.by/informatsiya/meditsinskie-kalkulyatory/994-raschet-indeksa-massy-tela
    Ввести Рост = 183 см
    Ввести Вес = 58 кг
    Нажать на кнопку ‘Рассчитать’
    Проверить, что значение в поле ‘ИМТ’ равно 17.32
    Проверить, что статус равен ’ Недостаточной массе тела’
    Закрыть окно браузера
     */
    @Test(enabled = false)
    public void smokeTest1() {
        driver.get("http://13gp.by/informatsiya/meditsinskie-kalkulyatory/994-raschet-indeksa-massy-tela");
        WebElement height = driver.findElement(By.name("ht"));
        WebElement weight = driver.findElement(By.name("mass"));
        WebElement calcBtn = driver.findElement(By.cssSelector("[type='button']"));
        WebElement results = driver.findElement(By.name("result"));
        WebElement imt = driver.findElement(By.id("resline"));
        //Actions
        height.sendKeys("183");
        weight.sendKeys("58");
        calcBtn.click();
        //Checks
        String actualResults = results.getAttribute("value");
        String actualImt = imt.getText();
        Assert.assertEquals(actualResults, "17.32");
        Assert.assertEquals(actualImt, "Недостаточной массе тела");
    }

    @Test(dataProvider = "data")
    public void smokeTest2(String cr, String age, String weight, String height, List<String> expectedData) {
        driver.get("http://13gp.by/informatsiya/meditsinskie-kalkulyatory/995-raschet-skorosti-klubochkovoj-filtratsii-skf");
        //Web Element
        WebElement gender = driver.findElement(By.id("oSex"));
        Select selectGender = new Select(gender);
        WebElement oCr = driver.findElement(By.id("oCr"));
        WebElement oAge = driver.findElement(By.id("oAge"));
        WebElement oWeight = driver.findElement(By.id("oWeight"));
        WebElement oHeight = driver.findElement(By.id("oHeight"));
        WebElement calcBtn = driver.findElement(By.cssSelector("[type='button']"));
        List<WebElement> results = driver.findElements(By.xpath("//form//li//div"));
        //Actions
        selectGender.selectByIndex(1);
        oCr.sendKeys(cr);
        oAge.sendKeys(age);
        oWeight.sendKeys(weight);
        oHeight.sendKeys(height);
        calcBtn.click();
        //Results
        List<String> actualData = new ArrayList<String>() {{
            results.forEach((element) -> add(element.getText()));
        }};
        Assert.assertEquals(actualData, expectedData);
    }

    @DataProvider(name = "data")
    private Object[][] getData() {
        return new Object[][]{
                {"80", "38", "55", "163", new ArrayList<String>() {{
                    add("MDRD: 74 (мл/мин/1,73кв.м)");
                    add("ХБП: 2 стадия (при наличии почечного повреждения)");
                    add("Cockroft-Gault: 70 (мл/мин)");
                    add("Поверхность тела:1.58 (кв.м)");
                }}},
                {"80", "40", "80", "190", new ArrayList<String>() {{
                    add("MDRD: 73 (мл/мин/1,73кв.м)");
                    add("ХБП: 2 стадия (при наличии почечного повреждения)");
                    add("Cockroft-Gault: 100 (мл/мин)");
                    add("Поверхность тела:2.08 (кв.м)");
                }}}
        };
    }

    @AfterTest
    public void close() {
        driver.quit();
    }
}
