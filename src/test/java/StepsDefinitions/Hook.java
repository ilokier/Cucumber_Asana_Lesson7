package StepsDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hook extends BaseTest {

    @Before
    public void intTitle(Scenario scenario) {
        System.out.println("Scenario start name: " + scenario.getName());

    }

    @After
    public void after(Scenario scenario) {
        System.out.println("Scenario end name: " + scenario.getName() + ", status: " + scenario.getStatus());

    }


}
