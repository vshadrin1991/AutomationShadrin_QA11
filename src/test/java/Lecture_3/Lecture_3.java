package Lecture_3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Lecture_3 {
    WebDriver driver = new ChromeDriver();

    @Test
    public void test1() {
        driver.get("http://the-internet.herokuapp.com/");
        driver.findElement(By.xpath("//div[text()='A/B Testing']")).click();
        driver.quit();
    }

}
