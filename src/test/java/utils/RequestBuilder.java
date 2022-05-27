package utils;


import StepsDefinitions.BaseTest;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

import static io.restassured.RestAssured.given;

public class RequestBuilder extends BaseTest {
    private static Logger logger = LoggerFactory.getLogger("RequestBuilder.class");

    public Response sendGetRequestForWorkspaces() {
        Response response = given()
                .spec(getRequestSpecification(data.getWorkspacesPath()))
                .get();
        logger.info("<<<<<Get response: " + response.asPrettyString());
        return response;
    }

    public Response sendGetRequestForProjects() {
        Response response = given()
                .spec(getRequestSpecification(data.getProjectsPath()))
                .get();
        logger.info("<<<<<Get response: " + response.asPrettyString());
        return response;
    }

    public Response sendPostRequestWithNewProject(String workspaceGID) {
        Response response = given()
                .spec(getRequestSpecification(data.getProjectInWorkspacePath()))
                .pathParam("workspace_gid", workspaceGID)
                .body(new File(projectDataPath))
                .post();
        logger.info("<<<<<Get response: " + response.asPrettyString());
        return response;
    }

    public Response sendDeleteRequestForProject(String projectGID) {
        Response response = given().contentType(ContentType.JSON)
                .spec(getRequestSpecification(data.getProjectsPath() + (data.getProjectPath())))
                .pathParam("project_gid", projectGID)
                .delete();
        logger.info("status code for delete: " + response.statusCode());

        return response;
    }
}
