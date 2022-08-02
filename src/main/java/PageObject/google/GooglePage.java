package PageObject.google;

import Modules.BaseDriverModule;
import com.google.inject.Inject;
import org.openqa.selenium.By;

import javax.inject.Named;

public class GooglePage extends BaseDriverModule {

    @Inject
    @Named("url")
    String URL;
    private final By search = By.name("q");

    public GooglePage goTo() {
        super.driver.get(this.URL);
        return this;
    }

    public GooglePage enterSearch(String key) {
        super.driver.findElement(search).sendKeys(key);
        return this;
    }
}
