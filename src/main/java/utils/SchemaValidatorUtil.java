package utils;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import utils.SoftAssertionUtil;

public class SchemaValidatorUtil {

    public static void validateResponseSchema(Response response, String schemaFileName) {
        // Use SchemaReader to read the schema file
        String schemaContent = SchemaReader.readSchema(schemaFileName);

        // Validate the response against the schema content using SoftAssertionUtil
        boolean isValid = false;
        String errorMessage = null;

        try {
            response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(schemaContent));
            isValid = true;
        } catch (AssertionError e) {
            errorMessage = e.getMessage();
        }

        // Use SoftAssertionUtil for the result
        SoftAssertionUtil.assertTrue(isValid, errorMessage != null ? "Schema validation failed: " + errorMessage : "Successfully validated schema from " + schemaFileName);
    }
}

