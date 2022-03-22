package PageObject.rabotaby.homepage;

import PageObject.BasePage;
import PageObject.rabotaby.homepage.elements.DashboardElement;
import PageObject.rabotaby.homepage.elements.FooterElement;
import PageObject.rabotaby.homepage.elements.HeaderElement;
import PageObject.rabotaby.homepage.elements.MainElement;


public class HomePage extends BasePage {

    public HeaderElement getHeaderElement() {
        return new HeaderElement();
    }

    public MainElement getMainElement() {
        return new MainElement();
    }

    public DashboardElement getDashboardElement() {
        return new DashboardElement();
    }

    public FooterElement getFooterElement() {
        return new FooterElement();
    }

    public HomePage open() {
        super.open();
        return this;
    }
}
