package PageObject.RabotaBy.HomePage.Elements;

import PageObject.RabotaBy.ElementInterface;
import PageObject.RabotaBy.HomePage.HomePage;
import org.openqa.selenium.By;
import org.testng.Assert;

public class DashboardElement extends HomePage implements ElementInterface {
    private By supernovaDashboardContent = By.cssSelector("[class='supernova-dashboard-content']");

    @Override
    public HomePage checkElement() {
        Assert.assertTrue(isElementExist(supernovaDashboardContent));
        return this;
    }
}
