package Driver;

import io.github.bonigarcia.wdm.config.DriverManagerType;

public class DriverManagerFactory {
    private static DriverManagerType driverManagerType;

    public DriverManagerFactory(DriverManagerType driverManagerType) {
        this.driverManagerType = driverManagerType;
    }

    public static DriverManager getManager() {
        return getManager(driverManagerType);
    }

    public static DriverManager getManager(DriverManagerType driverManagerType) {
        DriverManager driverManager = null;
        switch (driverManagerType) {
            case CHROME:
                driverManager = new ChromeDriverManager();
                break;
            case FIREFOX:
                driverManager = new FirefoxDriverManager();
                break;
        }
        return driverManager;
    }

}
