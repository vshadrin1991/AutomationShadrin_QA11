package Lecture_8;

import Lecture_8.PoJo.Root;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class Lecture_8 {

    @Test
    public void test1() throws IOException {
        Gson gson = new Gson();
        String data = getData();
        JsonObject jsonObject = gson.fromJson(data, JsonObject.class);
        System.out.println(jsonObject.get("menu").getAsJsonObject().get("food").getAsJsonArray().get(0).getAsJsonObject().get("name").getAsString());
        Assert.assertEquals(jsonObject.get("menu").getAsJsonObject().get("food").getAsJsonArray().get(0).getAsJsonObject().get("name").getAsString(), "Бельгийские Вафли");
    }

    @Test
    public void test2() throws IOException {
        Gson gson = new Gson();
        String data = getData();
        Root root = gson.fromJson(data, Root.class);
        System.out.println(root.getMenu().getFood().stream().filter(el -> el.getName().equals("Бельгийские Вафли")).collect(Collectors.toList()));
    }

    private String getData() throws IOException {
        return new String(Files.readAllBytes(Paths.get("src/test/java/Lecture_8/data.json")));
    }

}
