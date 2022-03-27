package PageObject.moodpanda;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.matchText;
import static com.codeborne.selenide.Selenide.$;

public class TestimonialsPage {

    SelenideElement testimonialsTxt = $("#testimonials .row.text-center h1");

    public TestimonialsPage verifyContentText(String text) {
        testimonialsTxt.shouldBe(matchText(text));
        return this;
    }
}
