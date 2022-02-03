package Lecture_7;


import BaseObjects.BaseTest;
import BaseObjects.DriverCreation;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static BaseObjects.DriverCreation.getDriver;

public class Lecture_7 extends BaseTest {

    @BeforeTest
    public void load() {
        driver.get(context.getSuite().getParameter("url"));
    }

    @Test
    public void test() {
        driver.findElement(By.id("user-name")).sendKeys("Hello");
    }

}
