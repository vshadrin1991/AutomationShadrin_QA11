package BaseObjects;

import com.google.inject.Inject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseDriverModule {

    @Inject
    protected WebDriver driver;

    @Inject
    protected Actions actions;

    @Inject
    protected WebDriverWait wait;

}
