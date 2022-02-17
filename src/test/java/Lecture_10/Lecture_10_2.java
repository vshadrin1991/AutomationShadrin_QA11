package Lecture_10;

import TestNgUtills.DataProviderStorage;
import TestNgUtills.Listener;
import TestNgUtills.Retry;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.internal.thread.ThreadTimeoutException;

@Listeners(Listener.class)
public class Lecture_10_2 {
    private long timeout = 3;

    @Test(enabled = false, priority = 1)
    public void test1() {
        System.out.println("Hello i am test 1");
    }

    @Parameters({"name"})
    @Test(enabled = true, priority = 2)
    public void test2(@Optional("Name") String name) {
        System.out.println("Hello i am test " + name);
    }

    @Test(timeOut = 1000, description = "Test 3", priority = 3)
    public void test3() {
        pause(1);
        System.out.println("Hello i am test 3");
    }


    @Test(dependsOnMethods = "test3", priority = 4)
    public void test4() {
        System.out.println("Hello i am test 4");
    }

    @Test(dependsOnMethods = "test3", alwaysRun = true, invocationCount = 3, invocationTimeOut = 2100, threadPoolSize = 3, priority = 5)
    public void test5() {
        pause(1);
        System.out.println("Hello i am test 5");
    }

    @Test(timeOut = 1000, priority = 6, expectedExceptions = ThreadTimeoutException.class)
    public void test6() {
        pause(2);
        System.out.println("Hello i am test 6");
    }

    @Test(timeOut = 1000, priority = 7, retryAnalyzer = Retry.class, enabled = false)
    public void test7() {
        pause(timeout);
        timeout = timeout > 1 ? (timeout - 1) : 0;
        System.out.println("Hello i am test 7");
    }

    @Test(dataProviderClass = DataProviderStorage.class, dataProvider = "Входящие данные для задачи TeachMeSkills", priority = 8)
    public void test8(double number, String expectedString) {
        System.out.println(number + " " + expectedString);
    }

    private void pause(long timeout) {
        try {
            Thread.sleep(timeout * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
