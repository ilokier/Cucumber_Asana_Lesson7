package StepsDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.RequestBuilder;

public class Hook extends BaseTest {
    private static Logger logger = LoggerFactory.getLogger("Hook.class");

    @Before
    public void intTitle(Scenario scenario) {
        System.out.println("Scenario start name: " + scenario.getName());

    }

    @After
    public void after(Scenario scenario) {
        System.out.println("Scenario end name: " + scenario.getName() + ", status: " + scenario.getStatus());

    }

    @After(value = "@post")
    public void clean(Scenario scenario) {
        requestBuilder = new RequestBuilder();
        //project = MrJson.readProject(projectPath);
        logger.info("projectGID =  " + project.getGid());
        response = requestBuilder.sendDeleteRequestForProject(project.getGid());
        System.out.println("Scenario end name with clean: " + scenario.getName() + ", status: " + scenario.getStatus());
    }

}
