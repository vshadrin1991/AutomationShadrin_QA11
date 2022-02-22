package PageObject.herokuapp;

public enum HomeLinks {
    AB_TESTING("A/B Testing"),
    CHECKBOXES("Checkboxes");

    String link;

    HomeLinks(String link) {
        this.link = link;
    }

    public String getLink() {
        return link;
    }
}
