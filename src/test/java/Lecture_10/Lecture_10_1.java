package Lecture_10;

import org.testng.annotations.*;

public class Lecture_10_1 {

    @BeforeSuite(groups = "Smoke")
    public void beforeSuite() {
        System.out.println("Hello i am before suite");
    }

    @BeforeClass(groups = "Smoke")
    public void beforeClass() {
        System.out.println("Hello i am before class");
    }

    @BeforeTest(groups = "Smoke")
    public void beforeTest() {
        System.out.println("Hello i am before test");
    }

    @BeforeGroups(groups = {"Smoke"})
    public void beforeGroups() {
        System.out.println("Hello i am before groups");
    }

    @BeforeMethod(groups = "Smoke")
    public void beforeMethod() {
        System.out.println("Hello i am before method");
    }

    @Test(groups = {"Smoke"})
    public void test1() {
        System.out.println("Hello i am test 1");
    }

    @Test(groups = {"Regression"})
    public void test2() {
        System.out.println("Hello i am test 2");
    }

    @AfterSuite(groups = "Smoke")
    public void afterSuite() {
        System.out.println("Hello i am after suite");
    }

    @AfterClass(groups = "Smoke")
    public void afterClass() {
        System.out.println("Hello i am after class");
    }

    @AfterTest(groups = "Smoke")
    public void afterTest() {
        System.out.println("Hello i am after test");
    }

    @AfterGroups(groups = {"Smoke"})
    public void afterGroups() {
        System.out.println("Hello i am after groups");
    }

    @AfterMethod(groups = "Smoke")
    public void afterMethod() {
        System.out.println("Hello i am after method");
    }

}
