package Lecture_17;

import Lecture_17.Users.Root;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Lecture_17 {

    @BeforeTest
    public void precondition() {
        baseURI = "https://reqres.in";
    }

    @Test(priority = 1)
    public void get_test() {
        Response response = given().when().get("/api/users/2");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
        Assert.assertEquals(response.then().extract().response().jsonPath().getInt("data.id"), 2);
        Assert.assertEquals(response.then().extract().response().jsonPath().get("data.email"), "janet.weaver@reqres.in");
        Assert.assertEquals(response.as(Root.class).data.id, 2);
    }

    @Test(priority = 1)
    public void get_2_test() {
        Response response = given().when().get("/api/users/2");
        response.then().body(matchesJsonSchema(getRequest("schema_my")))
                .assertThat().statusCode(200)
                .assertThat().body("data.id", equalTo(2))
                .assertThat().body("data.email", equalTo("janet.weaver@reqres.in"));
    }

    @Test(priority = 2)
    public void post_test() {
        Response response = given().when().header("Content-Type", "application/json").and().body(getRequest("create")).post("/api/users");
        response.then().assertThat().statusCode(201);
        Assert.assertEquals(response.then().extract().jsonPath().get("name"), "morpheus");
        Assert.assertEquals(response.then().extract().jsonPath().get("job"), "leader");
    }

    @Test(priority = 3)
    public void post_2_test() {
        Response response = given().when().header("Content-Type", "application/json").and().body(getRequest("create")).post("/api/users");
        response.then()
                .assertThat().statusCode(201)
                .assertThat().body("name", equalTo("morpheus"))
                .assertThat().body("job", equalTo("leader"));
    }


    private String getRequest(String json) {
        try {
            return new String(Files.readAllBytes(Paths.get("src/test/java/Lecture_17/Requests/" + json + ".json")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
