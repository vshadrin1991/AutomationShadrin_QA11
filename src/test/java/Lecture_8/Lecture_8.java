package Lecture_8;

import BaseObjects.BaseTest;
import Lecture_8.PoJo.Root;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Lecture_8 extends BaseTest {

    @Test(enabled = false)
    public void test1() throws IOException {
        Gson gson = new Gson();
        String data = getData();
        JsonObject jsonObject = gson.fromJson(data, JsonObject.class);
        System.out.println(jsonObject.get("menu").getAsJsonObject().get("food").getAsJsonArray().get(0).getAsJsonObject().get("name").getAsString());
        Assert.assertEquals(jsonObject.get("menu").getAsJsonObject().get("food").getAsJsonArray().get(0).getAsJsonObject().get("name").getAsString(), "Бельгийские Вафли");
    }

    @Test(enabled = false)
    public void test2() throws IOException {
        Gson gson = new Gson();
        String data = getData();
        Root root = gson.fromJson(data, Root.class);
        System.out.println(root.getMenu().getFood().stream().filter(el -> el.getName().equals("Бельгийские Вафли")).collect(Collectors.toList()));
    }

    @Test
    void test3() {
        driver.get("file:///home/vshadrin/Projects/QA11/AutomationShadrin_QA11/src/test/java/Lecture_8/index.html");
        List<String> headers = new ArrayList<String>() {{
            driver.findElements(By.tagName("th")).forEach(data -> add(data.getText()));
        }};
        Map<String, List<String>> mapData = new HashMap<String, List<String>>() {{
            for (int index = 0; index < headers.size(); index++) {
                put(headers.get(index), driver.findElements(By.xpath("//td[" + (index + 1) + "]")).stream().map(WebElement::getText).collect(Collectors.toList()));
            }
        }};
        System.out.println(mapData);
    }

    private String getData() throws IOException {
        return new String(Files.readAllBytes(Paths.get("src/test/java/Lecture_8/data.json")));
    }

}
