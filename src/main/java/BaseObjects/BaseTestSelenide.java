package BaseObjects;

import Properties.PropertyReader;
import TestNgUtills.Listener;
import TestNgUtills.SelenideListener;
import lombok.extern.log4j.Log4j2;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.driver;

@Log4j2
@Listeners(SelenideListener.class)
public abstract class BaseTestSelenide {
    PropertyReader propertyReader;
    ITestContext context;

    @BeforeTest
    public void precondition(ITestContext context){
        this.context = context;
        this.propertyReader = new PropertyReader(context.getSuite().getParameter("config"));
    }

    public <Type> Type get(Class<Type> pageObjectClassClass) {
        return driver().hasWebDriverStarted() ? page(pageObjectClassClass) : open(PropertyReader.getProperties().getProperty("url"), pageObjectClassClass);
    }

    @AfterTest
    public void postconditions(){
        driver().close();
    }
}
