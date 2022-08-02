package Modules;

import TestNgUtills.InvokedMethodsListener;
import TestNgUtills.Listener;
import com.google.inject.Injector;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Guice;
import org.testng.annotations.Listeners;

import java.lang.reflect.InvocationTargetException;

import static Driver.DriverManager.closeDriver;

@Listeners({Listener.class, InvokedMethodsListener.class})
@Guice(modules = {DriverModule.class})
public class BaseTestModule {

    protected <T> T get(Class<T> page) {
        Injector injector = com.google.inject.Guice.createInjector(new DriverModule());
        return injector.getInstance(page);
    }

    @AfterTest(alwaysRun = true)
    public void postcondition() {
        closeDriver();
    }

}
