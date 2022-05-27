package StepsDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.MrJson;
import utils.RequestBuilder;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class StepDefinitionsAsana extends BaseTest {
    private static Logger logger = LoggerFactory.getLogger("StepDefinitions.class");
    private static String workspaceGID;
    // private static String projectGID;

    @Given("I have workspace object")
    public void i_have_workspace_object() {
        workspace = MrJson.readWorkspace(workspacePath);
        requestBuilder = new RequestBuilder();
    }

    @When("User perform astana GET workspace operation")
    public void user_perform_astana_GET_workspace_operation() {
        response = requestBuilder.sendGetRequestForWorkspaces();
    }

    @Then("User is able to see response with workspace details")
    public void user_is_able_to_see_response_with_workspace_details() {
        response
                .then()
                .spec(getResponseSpecification(data.getGetStatusCode()))
                .extract().response();
        JsonPath jsonPath = response.jsonPath();
        workspace.setGid(jsonPath.get("data[0].gid"));
        logger.info("<<<<<<<>>>>>>>>>>WorkspaceGID: " + workspace.getGid());
        assertThat(jsonPath.get("data[0].name"), equalTo(workspace.getName()));
        assertThat(jsonPath.get("data[0].resource_type"), equalTo(workspace.getResource_type()));
    }

    //    post
    @Given("I have project object")
    public void i_have_project_object() {
        project = MrJson.readProject(projectPath);
        workspace = MrJson.readWorkspace(workspacePath);
        requestBuilder = new RequestBuilder();
    }

    @When("User perform astana POST project operation")
    public void user_perform_astana_POST_project_operation() {
        response = requestBuilder.sendPostRequestWithNewProject(workspace.getGid());
    }

    @Then("User is able to see response with project details")
    public void user_is_able_to_see_response_with_project_details() {
        response
                .then()
                .spec(getResponseSpecification(data.getPostStatusCode()))
                .extract().response();
        JsonPath jsonPath = response.jsonPath();
        project.setGid(jsonPath.get("data.gid"));
        logger.info("<<<<<<<>>>>>>>>>>ProjectGID: " + project.getGid());
        assertThat(jsonPath.get("data.name"), equalTo(project.getName()));
        assertThat(jsonPath.get("data.resource_type"), equalTo(project.getResource_type()));
    }
}