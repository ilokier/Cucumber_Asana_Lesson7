package utils;


import StepsDefinitions.BaseTest;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.restassured.RestAssured.given;

public class RequestBuilder extends BaseTest {
    private static Logger logger = LoggerFactory.getLogger("RequestBuilder.class");

    public Response sendGetRequestForWorkspaces() {
        Response response = given()
                .spec(getRequestSpecification())
                .get();
        logger.info("<<<<<Get response: " + response.asPrettyString());
        return response;
    }
}
