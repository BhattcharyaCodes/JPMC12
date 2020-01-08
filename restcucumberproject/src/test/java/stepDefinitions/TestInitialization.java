package stepDefinitions;

import io.cucumber.java.Before;
import utilities.RestAssuredExtension;

public class TestInitialization {

    @Before
    public void TestSetup() {
        RestAssuredExtension restAssuredExtension = new RestAssuredExtension();
    }
}
