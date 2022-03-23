package PageObject.RabotaBy.HomePage;

import PageObject.BasePage;
import PageObject.RabotaBy.HomePage.Elements.DashboardElement;
import PageObject.RabotaBy.HomePage.Elements.FooterElement;
import PageObject.RabotaBy.HomePage.Elements.HeaderElement;
import PageObject.RabotaBy.HomePage.Elements.MainElement;


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
