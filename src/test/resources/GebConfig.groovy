import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import io.github.bonigarcia.wdm.WebDriverManager;

environments {

    chrome {
        WebDriverManager.chromedriver().setup()
        driver = { new ChromeDriver() }
    }

    firefox {
        WebDriverManager.firefoxdriver().setup()
        driver = { new FirefoxDriver() }
    }

    baseUrl = "https://www.google.com/"
    baseNavigatorWaiting = true
    atCheckWaiting = true
}