package api;

import io.restassured.RestAssured;

import io.restassured.specification.RequestSpecification;

public class APIBase {

    protected RequestSpecification request;

    public APIBase() {

        RestAssured.baseURI =
                "https://jsonplaceholder.typicode.com";

        request =
                RestAssured
                        .given()

                        .header("Content-Type",
                                "application/json");
    }
}