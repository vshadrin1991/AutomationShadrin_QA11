package Lecture_2;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Lecture_2 {

    @Test
    public void test_1() {
        Assert.assertEquals(getData(3), "T");
    }

    @Test()
    public void test_2() {
        Assert.assertEquals(getData(5), "M");
    }

    @Test
    public void test_3() {
        Assert.assertEquals(getData(15), "S");
    }

    @Test
    public void test_4() {
        Assert.assertTrue(getData(2).isEmpty());
    }

    public String getData(Integer value) {
        if (value % 3 == 0 && value % 15 != 0) {
            return "T";
        } else if (value % 5 == 0 && value % 15 != 0) {
            return "M";
        } else if (value % 15 == 0) {
            return "S";
        }
        return "";
    }
}
