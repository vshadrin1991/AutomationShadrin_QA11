package Lecture_8.PoJo;

public class Root {
    Menu menu;

    public Menu getMenu() {
        return menu;
    }

    @Override
    public String toString() {
        return "Root{" +
                "menu=" + menu +
                '}';
    }
}
