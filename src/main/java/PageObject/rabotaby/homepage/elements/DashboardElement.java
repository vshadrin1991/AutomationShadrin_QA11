package PageObject.rabotaby.homepage.elements;

import PageObject.rabotaby.homepage.HomePage;
import org.openqa.selenium.By;
import org.testng.Assert;

public class DashboardElement extends HomePage implements HomeInterface {
    private By supernovaDashboardContent = By.cssSelector("[class='supernova-dashboard-content']");

    @Override
    public HomePage checkElement() {
        Assert.assertTrue(isElementExist(supernovaDashboardContent));
        return this;
    }
}
