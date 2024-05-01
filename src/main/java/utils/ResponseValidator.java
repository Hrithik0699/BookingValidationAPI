package utils;

import io.restassured.response.Response;

public class ResponseValidator {
    public static void validateStatusCode(Response response, int expectedStatusCode) {
        response.then().statusCode(expectedStatusCode);
    }
}
