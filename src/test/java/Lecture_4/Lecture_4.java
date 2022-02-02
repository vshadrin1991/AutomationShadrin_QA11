package Lecture_4;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;


public class Lecture_4 {
    private WebDriver driver;
    private Map<String, String> userData = new HashMap<>();

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.manage().window().setSize(new Dimension(1503, 1010));
    }

    @Test(priority = 1)
    public void zipCodeTest() {
        Assert.assertTrue(driver.findElement(By.name("zip_code")).isDisplayed());
        driver.findElement(By.name("zip_code")).click();
        driver.findElement(By.name("zip_code")).sendKeys("1111111");
        String notEmptyValue = driver.findElement(By.name("zip_code")).getAttribute("value");
        Assert.assertEquals(notEmptyValue, "1111111");

        driver.findElement(By.name("zip_code")).clear();
        String emptyValue = driver.findElement(By.name("zip_code")).getAttribute("value");
        Assert.assertEquals(emptyValue, "");

        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector(".error_message")).getText(), "Oops, error on page. ZIP code should have 5 digits");
    }

    @Test(priority = 2)
    public void signUpTest() {
        driver.findElement(By.name("zip_code")).sendKeys("1111111");
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        driver.findElement(By.name("first_name")).click();
        driver.findElement(By.name("first_name")).sendKeys("TestUser");
        driver.findElement(By.name("last_name")).click();
        driver.findElement(By.name("last_name")).sendKeys("TestUser");
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).sendKeys("testuser@gmail.com");
        driver.findElement(By.name("password1")).click();
        driver.findElement(By.name("password1")).sendKeys("11111111111");
        driver.findElement(By.name("password2")).click();
        driver.findElement(By.name("password2")).sendKeys("11111111111");
        driver.findElement(By.xpath("//input[@value='Register']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//td[contains(.,'Account is created!')]")).isDisplayed());
        Assert.assertEquals(driver.findElement(By.cssSelector(".confirmation_message")).getText(), "Account is created!");
        String email = driver.findElement(By.xpath("//table[@align='center']//b")).getText();
        Assert.assertTrue(email.contains("sharelane.com"));
        String password = driver.findElement(By.xpath("//table[@border='1']/tbody/tr[2]/td[2]")).getText();
        Assert.assertEquals(password, "1111");
        userData.put("email", email);
        userData.put("password", password);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
