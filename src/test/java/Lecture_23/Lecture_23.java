package Lecture_23;

import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.Test;

public class Lecture_23 {

    @Test
    public void test(){
        String find = "(найдено 287 тем)";
        System.out.println(Integer.parseInt(find.split(" ")[1]));
        System.out.println(Integer.parseInt(StringUtils.substringBetween(find, " ")));
        System.out.println(Integer.parseInt(StringUtils.substringBetween(find, "найдено", "тем").trim()));
    }
}
