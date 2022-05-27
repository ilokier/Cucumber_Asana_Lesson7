package StepsDefinitions;

import Models.Project;
import Models.Workspace;
import TestData.Data;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import utils.MrJson;
import utils.RequestBuilder;

import static io.restassured.RestAssured.given;

public class BaseTest {
    private static final String dataPath = "src/test/java/TestData/Data.json";
    protected static String workspacePath = "src/test/java/TestData/Workspace.json";
    protected static String projectPath = "src/test/java/TestData/Project.json";
    protected static String projectDataPath = "src/test/java/TestData/Create_project.json";
    protected static Data data = MrJson.readData(dataPath);
    protected Response response;
    protected RequestBuilder requestBuilder;
    protected Workspace workspace;
    protected Project project;

    public RequestSpecification getRequestSpecification(String workspaceURL) {
        RequestSpecification requestSpecification =
                given()
                        .auth().oauth2(data.getToken())
                        .log()
                        .all()
                        .baseUri(data.getBaseURI())
                        .basePath(workspaceURL);
        return requestSpecification;
    }

    public ResponseSpecification getResponseSpecification(int statusCode) {
        ResponseSpecification responseSpecification = RestAssured.expect();
        responseSpecification
                .log()
                .all()
                .contentType(ContentType.JSON)
                .statusCode(statusCode);
        return responseSpecification;
    }

}
