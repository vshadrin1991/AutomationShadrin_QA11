package Lecture_18;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Configuration.browserSize;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selectors.*;

public class Lecture_18 {

    @Test
    public void test1() {
        browserSize = "1800x1000";
        open("https://moodpanda.com/");

        $(By.xpath("//a[@class='navbar-brand page-scroll']")).shouldBe(exist);
        $(".scroll-down > a").click();
        Assert.assertTrue($("#bs-example-navbar-collapse-1").findAll(byXpath("ul//li//a")).size() > 4);
        $("#bs-example-navbar-collapse-1").findAll(byXpath("ul//li//a")).shouldBe(sizeGreaterThan(4));
    }
}
