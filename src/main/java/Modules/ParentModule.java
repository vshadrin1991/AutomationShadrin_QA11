package Modules;

import com.google.inject.AbstractModule;
import org.testng.ITestContext;

public class ParentModule extends AbstractModule {
    private static ITestContext context;

    public ParentModule(ITestContext context) {
        this.context = context;
    }

    public ParentModule() {}

    public static ITestContext getContext() {
        return context;
    }

    @Override
    protected void configure() {
        bind(ITestContext.class).toInstance(context);
    }
}
