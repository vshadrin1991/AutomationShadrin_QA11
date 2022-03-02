package PageObject.herokuapp;

public enum HomeLinks {
    AB_TESTING("A/B Testing"),
    CHECKBOXES("Checkboxes"),
    JS_ALERT("JavaScript Alerts"),
    FRAMES("Frames");

    String link;

    HomeLinks(String link) {
        this.link = link;
    }

    public String getLink() {
        return link;
    }
}
