package StepsDefinitions;

import TestData.Data;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import utils.MrJson;
import utils.RequestBuilder;

import java.io.File;

import static io.restassured.RestAssured.given;

public class BaseTest {
    private static final String dataPath = "src/test/java/TestData/Data.json";
    protected static Data data = MrJson.readData(new File(dataPath));
    protected Response response;
    protected RequestBuilder requestBuilder;

    public RequestSpecification getRequestSpecification() {
        RequestSpecification requestSpecification =
                given()
                        .auth().oauth2(data.getToken())
                        .log()
                        .all()
                        .baseUri(data.getBaseURI())
                        .basePath(data.getWorkspacesPath());
        return requestSpecification;
    }

    public ResponseSpecification getResponseSpecification() {
        ResponseSpecification responseSpecification = RestAssured.expect();
        responseSpecification
                .log()
                .all()
                .contentType(ContentType.JSON)
                .statusCode(data.getGetStatusCode());
        return responseSpecification;
    }

}
