package Lecture_17;

import Lecture_17.Users.Root;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

public class Lecture_17 {

    @BeforeTest
    public void precondition() {
        baseURI = "https://reqres.in";
    }

    //@Test(priority = 1)
    public void get_test() {
        Response response = given().when().get("/api/users/2");
        response.then().assertThat().statusCode(200);
        Assert.assertEquals(response.then().extract().response().jsonPath().getInt("data.id"), 2);
        Assert.assertEquals(response.then().extract().response().jsonPath().get("data.email"), "janet.weaver@reqres.in");
        Assert.assertEquals(response.as(Root.class).data.id, 2);
    }

    //@Test(priority = 2)
    public void post_test() {
        Response response = given().when().header("Content-Type", "application/json").and().body(getJsonData("create")).post("/api/users");
        response.then().assertThat().statusCode(201);
        Assert.assertEquals(response.then().extract().jsonPath().get("name"), "morpheus");
        Assert.assertEquals(response.then().extract().jsonPath().get("job"), "leader");
    }

    //@Test(priority = 3)
    public void user_test() {
        Response response = given().when().get("/api/users/3");
        response.then()
                .assertThat().body("data.id", equalTo(3))
                .assertThat().body("support.text", containsString("ReqRes"));
    }


    //@Test(priority = 4)
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
