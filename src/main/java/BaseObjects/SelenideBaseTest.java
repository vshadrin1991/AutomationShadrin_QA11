package BaseObjects;

import Properties.PropertyReader;
import org.testng.ITestContext;
import org.testng.annotations.BeforeTest;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.driver;

public class SelenideBaseTest {
    private ITestContext context;
    private PropertyReader propertyReader;

    @BeforeTest
    public void preconditions(ITestContext context){
        this.context = context;
        this.propertyReader = new PropertyReader(context.getSuite().getParameter("config"));
    }

    protected <T> T get(Class<T> pageClass) {
        return driver().hasWebDriverStarted() ? page(pageClass) : open(PropertyReader.getProperties().getProperty("url"), pageClass);
    }
}
