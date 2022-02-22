package PageObject.herokuapp;

public enum HomeLinks {
    CONTEXT_MENU("Context Menu"),
    AB_TESTING("A/B Testing"),
    CHECKBOXES("Checkboxes"),
    FILE_UPLOADER("File Upload"),
    FRAMES("Frames"),
    DYNAMIC_CONTROLS("Dynamic Controls");

    String link;

    HomeLinks(String link) {
        this.link = link;
    }

    public String getLink() {
        return link;
    }
}
