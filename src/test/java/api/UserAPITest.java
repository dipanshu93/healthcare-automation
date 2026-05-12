package api;

import io.restassured.response.Response;
import pojo.CreatePostRequest;
import pojo.CreatePostResponse;
import utils.JsonUtil;

import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.CreatePostRequest;
import pojo.CreatePostResponse;

public class UserAPITest
        extends APIBase {

    @Test
    public void getUsersTest() {

        Response response =

                request
                        .when()

                        .get("/users");

        // Print response
        System.out.println(
                response.getBody()
                        .asPrettyString());

        // Validate status code
        Assert.assertEquals(
                response.getStatusCode(),
                200);

        // Validate user
        Assert.assertEquals(
                response.jsonPath()
                        .getString("[0].name"),
                "Leanne Graham");
    }

    @Test
    public void createUserTest()
            throws Exception {

        String requestBody =

                JsonUtil.readJsonFile(
                        "src/test/resources/payloads/createUser.json");

        Response response =

                request
                        .body(requestBody)

                        .when()

                        .post("/posts");

        // Print response
        System.out.println(
                response.getBody()
                        .asPrettyString());

        // Validate status code
        Assert.assertEquals(
                response.getStatusCode(),
                201);

        // Validate response
        Assert.assertEquals(
                response.jsonPath()
                        .getString("title"),
                "QA Engineer");
    }
    @Test
    public void createPostUsingPojoTest() {

        // Create request object
        CreatePostRequest requestBody =
                new CreatePostRequest();

        requestBody.setTitle("Senior QA");

        requestBody.setBody("Rest Assured Automation");

        requestBody.setUserId(101);

        // Send request
        CreatePostResponse response =

                request
                        .body(requestBody)

                        .when()

                        .post("/posts")

                        .then()

                        .extract()

                        .as(CreatePostResponse.class);

        // Validation
        Assert.assertEquals(
                response.getTitle(),
                "Senior QA");

        Assert.assertEquals(
                response.getUserId(),
                101);

        System.out.println(
                "Created ID: "
                        + response.getId());
    }
}