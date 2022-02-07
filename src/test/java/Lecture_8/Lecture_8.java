package Lecture_8;

import Lecture_8.PoJo.User;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Lecture_8 {

    @Test
    public void test_1() throws Exception {
        Gson gson = new Gson();
        String json = readFileAsString();
        JsonObject jsonObject = gson.fromJson(json, JsonObject.class);
        System.out.println(jsonObject);
        System.out.println(jsonObject);
        System.out.println(jsonObject.get("orderID"));
        System.out.println(jsonObject.get("contents").getAsJsonArray().get(0).getAsJsonObject().get("productID"));
        System.out.println(jsonObject.get("contents").getAsJsonArray().get(1).getAsJsonObject().get("productID"));
    }

    @Test
    public void test2() throws Exception {
        Gson gson = new Gson();
        String json = readFileAsString();
        User user = gson.fromJson(json, User.class);
        System.out.println(user);
        System.out.println(user.getOrderID());
        System.out.println(user.getContents().get(0).getProductID());
        System.out.println(user.getContents().get(1).getProductID());
    }

    @Test
    public void test3() throws Exception {
        Gson gson = new Gson();
        String json = readFileAsString();
        User user = gson.fromJson(json, User.class);
        JsonObject jsonObject = gson.fromJson(json, JsonObject.class);
        Assert.assertEquals(user.getOrderID().doubleValue(), jsonObject.get("orderID").getAsDouble());
    }

    public static String readFileAsString() throws Exception {
        return new String(Files.readAllBytes(Paths.get("src/test/java/Lecture_8/data.json")));
    }

}
