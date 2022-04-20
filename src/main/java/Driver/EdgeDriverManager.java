package Driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class EdgeDriverManager extends DriverManager {

    @Override
    public void createDriver() {
        WebDriverManager.edgedriver().setup();
        WebDriver webDriver = new EdgeDriver();
        driver.set(webDriver);
    }
}
