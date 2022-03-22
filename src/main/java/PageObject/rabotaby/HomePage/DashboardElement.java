package PageObject.rabotaby.HomePage;

import PageObject.BasePage;
import org.openqa.selenium.By;
import org.testng.Assert;

public class DashboardElement extends BasePage {
    private By supernovaDashboardContent = By.cssSelector("[class='supernova-dashboard-content']");

    public DashboardElement checkDashboardContent() {
        Assert.assertTrue(isElementExist(supernovaDashboardContent));
        return this;
    }
}
