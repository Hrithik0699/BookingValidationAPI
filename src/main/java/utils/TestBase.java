package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import endpoints.BookingEndpoints;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import org.apache.commons.io.FileUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import static io.restassured.RestAssured.baseURI;
import static org.hamcrest.MatcherAssert.assertThat;


public class TestBase {
    public static final String BASE_URI = "https://restful-booker.herokuapp.com";
    protected static String authToken;
    ExtentReports extent = ReportManager.getExtentReport();
    ExtentTest test;

    @BeforeMethod
    public void initialize(){
        initializationOfExtentReport();
    }

    @Test
    public void setUp() {
        baseURI = BASE_URI;

        obtainAuthToken();
    }

    public void initializationOfExtentReport(){

        test = extent.createTest("API Test Name");
    }

    private void obtainAuthToken() {
        try {
            // Specify the path to the JSON file
            String filePath = "JSONData/auth_request_body.json";

            // Read the contents of the JSON file
            String requestBody = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);

            // Request body
            Response response = RestAssured.given()
                    .header("Content-Type", "application/json")
                    .body(requestBody)
                    .post(BookingEndpoints.BOOKINGS_AUTH);

            response.then().statusCode(200);

            authToken = response.jsonPath().getString("token");


        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void tearDown() {
        extent.flush();
    }
}
