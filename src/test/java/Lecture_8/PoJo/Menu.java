package Lecture_8.PoJo;

import java.util.List;

public class Menu {
     List<Food> food;
     Boolean pp;

    public List<Food> getFood() {
        return food;
    }

    public Boolean getPp() {
        return pp;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "food=" + food +
                ", pp=" + pp +
                '}';
    }
}
