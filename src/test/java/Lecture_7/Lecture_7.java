package Lecture_7;


import BaseObjects.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Lecture_7 extends BaseTest {

    @BeforeTest
    public void load() {
        driver.get(context.getSuite().getParameter("url"));
    }

    @Test
    public void test() {
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .ignoring(NotFoundException.class)
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name")));
        driver.findElement(By.id("user-name")).sendKeys("Hello");
    }

}
