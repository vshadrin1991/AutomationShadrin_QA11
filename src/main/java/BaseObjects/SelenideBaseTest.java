package BaseObjects;

import TestNgUtills.ListenerSelenide;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.Listeners;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.driver;

@Listeners(ListenerSelenide.class)
public class SelenideBaseTest {

    protected <T> T get(Class<T> pageClass) {
        return driver().hasWebDriverStarted() ? page(pageClass) : open(Configuration.baseUrl, pageClass);
    }
}
