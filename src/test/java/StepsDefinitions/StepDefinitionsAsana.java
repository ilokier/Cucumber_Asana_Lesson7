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
import static org.hamcrest.Matchers.is;

public class StepDefinitionsAsana extends BaseTest {
    private static Logger logger = LoggerFactory.getLogger("StepDefinitions.class");
    private static String workspaceGID;

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
        workspaceGID = jsonPath.get("data[0].gid");
        logger.info("<<<<<<<>>>>>>>>>>WorkspaceGID: " + workspaceGID);
        assertThat(workspaceGID, equalTo(workspace.getGid()));
        assertThat(jsonPath.get("data[0].name"), equalTo(workspace.getName()));
        assertThat(jsonPath.get("data[0].resource_type"), equalTo(workspace.getResource_type()));


    }

    //    post
    @Given(": I have project object")
    public void i_have_project_object() {
        project = MrJson.readProject(projectPath);
        requestBuilder = new RequestBuilder();

    }

    @When("User perform astana POST workspace operation")
    public void user_perform_astana_POST_workspace_operation() {
        logger.info("<<<<<<<>>>>>>>>>>WorkspaceGID: " + workspaceGID);
        response = requestBuilder.sendPostRequestWithNewProject(workspaceGID);

    }

    @Then("User is able to see response with project details")
    public void user_is_able_to_see_response_with_project_details() {
        response
                .then()
                .spec(getResponseSpecification(data.getPostStatusCode()))
                .body("data.name", is(project.getName()));

    }
}