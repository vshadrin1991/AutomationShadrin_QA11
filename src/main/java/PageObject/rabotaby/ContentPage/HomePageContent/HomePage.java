package PageObject.rabotaby.ContentPage.HomePageContent;

import PageObject.BasePage;

public class HomePage extends BasePage {

    public DashboardElement getDashboardElement() {
        return new DashboardElement();
    }

    public MainElement getMainElement() {
        return new MainElement();
    }

    public HomePage open(){
        super.open();
        return this;
    }
}
