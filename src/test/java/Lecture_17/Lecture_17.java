package Lecture_17;

import Lecture_17.Users.Data;
import Lecture_17.Users.Root;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class Lecture_17 {

    @BeforeTest
    public void precondition() {
        baseURI = "https://reqres.in";
    }

    @Test
    public void onlinerCatalog_Test() throws URISyntaxException, IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newHttpClient();
        Gson gson = new Gson();
        //Apple catalog
        HttpRequest catalog = HttpRequest
                .newBuilder()
                .uri(new URI("https://catalog.onliner.by/sdapi/catalog.api/search/mobile?on_sale=1&mfr[0]=apple&group=1"))
                .GET()
                .build();
        HttpResponse<String> responseCatalog = httpClient.send(catalog, HttpResponse.BodyHandlers.ofString());
        JsonObject catalogObject = gson.fromJson(responseCatalog.body(), JsonObject.class);

        String productId = catalogObject.getAsJsonArray("products").get(0).getAsJsonObject().get("id").getAsString();
        String productKey = catalogObject.getAsJsonArray("products").get(0).getAsJsonObject().get("key").getAsString();
        String productName = catalogObject.getAsJsonArray("products").get(0).getAsJsonObject().get("name").getAsString();
        //Positions
        HttpRequest positions = HttpRequest
                .newBuilder()
                .uri(new URI("https://catalog.onliner.by/sdapi/shop.api/products/" + productKey + "/positions"))
                .GET()
                .build();
        HttpResponse<String> responsePositions = httpClient.send(positions, HttpResponse.BodyHandlers.ofString());
        JsonObject positionsObject = gson.fromJson(responsePositions.body(), JsonObject.class);
        String positionId = positionsObject.getAsJsonObject("positions").getAsJsonArray("primary").get(0).getAsJsonObject().get("id").getAsString();
        String shopId = positionsObject.getAsJsonObject("positions").getAsJsonArray("primary").get(0).getAsJsonObject().get("shop_id").getAsString();
        //Add bin
        Bin binBody = Bin.builder().position_id(positionId).product_id(productId).shop_id(shopId).product_key(productKey).quantity(1).build();
        HttpRequest bin = HttpRequest
                .newBuilder()
                .uri(new URI("https://catalog.onliner.by/sdapi/cart.api/detached-cart/add"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(gson.toJson(binBody)))
                .build();

        HttpResponse<String> binResponse = httpClient.send(bin, HttpResponse.BodyHandlers.ofString());
        JsonObject binResponseObject = gson.fromJson(binResponse.body(), JsonObject.class);
        String cartId = binResponseObject.get("cart_id").getAsString();
        //Gte bin
        HttpRequest getBin = HttpRequest
                .newBuilder()
                .uri(new URI("https://catalog.onliner.by/sdapi/cart.api/v2/detached-cart/" + cartId))
                .GET()
                .build();
        HttpResponse<String> responseGetBin = httpClient.send(getBin, HttpResponse.BodyHandlers.ofString());
        JsonObject responseGetBinObject = gson.fromJson(responseGetBin.body(), JsonObject.class);
        String actualProductName = responseGetBinObject
                .getAsJsonArray("position_groups")
                .get(0)
                .getAsJsonObject()
                .getAsJsonArray("positions")
                .get(0)
                .getAsJsonObject()
                .get("product")
                .getAsJsonObject()
                .get("name")
                .getAsString();
        Assert.assertEquals(actualProductName, productName);
    }


    @Test(priority = 1)
    public void get_test() {
        Response response = given().when().get("/api/users/2");
        response.then().assertThat().statusCode(200);
        Assert.assertEquals(response.then().extract().response().jsonPath().getInt("data.id"), 2);
        Assert.assertEquals(response.then().extract().response().jsonPath().get("data.email"), "janet.weaver@reqres.in");
        Assert.assertEquals(response.as(Root.class).data.id, 2);
    }

    @Test(priority = 2)
    public void post_test() {
        Response response = given().when().header("Content-Type", "application/json").and().body(getJsonData("create")).post("/api/users");
        response.then().assertThat().statusCode(201);
        Assert.assertEquals(response.then().extract().jsonPath().get("name"), "morpheus");
        Assert.assertEquals(response.then().extract().jsonPath().get("job"), "leader");
    }

    @Test(priority = 3)
    public void user_test() {
        Response response = given().when().get("/api/users/3");
        response.then()
                .assertThat().body("data.id", equalTo(3))
                .assertThat().body("support.text", containsString("ReqRes"));
    }


    @Test(priority = 4)
    public void jsonSchema_test() {
        Response response = given().when().get("/api/users/4");
        response.then().assertThat().body(matchesJsonSchema(getJsonData("jsonSchemaUser")));
    }

    @Test(priority = 5)
    public void jsonSchemaArray_test() {
        Response response = given().when().get("/api/users?page=2");
        response.prettyPrint();
        response.then().assertThat().body(matchesJsonSchema(getJsonData("jsonSchemaUserArray")));
    }


    private String getJsonData(String name) {
        try {
            return new String(Files.readAllBytes(Paths.get("src/test/java/Lecture_17/Requests/" + name + ".json")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
