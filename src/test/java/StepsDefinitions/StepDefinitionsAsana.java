package StepsDefinitions;

import Models.Workspace;
import TestData.Data;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import utils.MrJson;
import utils.RequestBuilder;

import java.io.File;
import static org.hamcrest.Matchers.is;

public class StepDefinitionsAsana extends BaseTest {
    private static String Workspace_path = "src/test/java/TestData/Workspace.json";
    private Workspace workspace;
    @Given("I have workspace object")
    public void i_have_workspace_object() {
        workspace = MrJson.readWorkspace(new File(Workspace_path));
        requestBuilder = new RequestBuilder();
    }

    @When("User perform astana GET workspace operation")
    public void user_perform_astana_GET_workspace_operation() {
        System.out.println("middle");
        requestBuilder = new RequestBuilder();
        response = requestBuilder.sendGetRequestForWorkspaces();
    }

    @Then("User is able to see response with workspace details")
    public void user_is_able_to_see_response_with_workspace_details() {
        System.out.println("end");
        response
                .then()
                .spec(getResponseSpecification())
                .body("data[0].gid", is(workspace.getGid()))
                .body("data[0].name", is(workspace.getName()))
                .body("data[0].resource_type", is(workspace.getResource_type()));
    }
}
