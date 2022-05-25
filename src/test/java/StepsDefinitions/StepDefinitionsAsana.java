package StepsDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.MrJson;
import utils.RequestBuilder;

import static org.hamcrest.Matchers.is;

public class StepDefinitionsAsana extends BaseTest {
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
                .spec(getResponseSpecification())
                .body("data[0].gid", is(workspace.getGid()))
                .body("data[0].name", is(workspace.getName()))
                .body("data[0].resource_type", is(workspace.getResource_type()));
    }
}
