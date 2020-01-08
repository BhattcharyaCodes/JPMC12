package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ResponseOptions;
import org.hamcrest.Matchers;
import utilities.RestAssuredExtension;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class userStepDefinition {

    private static ResponseOptions<Response> response;

    @Given("users exist in the database")
    public void usersExistInTheDatabase() throws Throwable {
        //Write code here that sets up users in the database in a testing server. For example, code to start a fake JSON DB server can go here.
        System.out.println("Database Seeded: You can now start running your tests.");
    }


    @When("I perform GET operation for {string}")
    public void iPerformGETOperationFor(String url) throws Throwable {
        response = RestAssuredExtension.GetOps(url);
        assert response != null;
        ResponseBody body = response.getBody();
        System.out.println(body.asString());
    }

    @Then("I should receive {int} status code")
    public void iShouldReceiveStatusCode(int statusCode) throws Throwable {
        assertThat(response.statusCode(), equalTo(200));
    }

    @Given("a user exists with a valid id")
    public void aUserExistsWithAValidId() {
        //Write code here that sets up users in the database with valid test ids
        System.out.println("Database Seeded: You can now start running your tests.");
    }

    @Then("I should see the user's name as {string}")
    public void iShouldSeeTheUserSNameAs(String arg0) {
    }

    @And("I perform GET operation for userId {string}")
    public void iPerformGETOperationForUserId(String userId) {
        response = RestAssuredExtension.GetOps(String.format("/users/%s", userId));
        assert response != null;
        assertThat(response.getBody().jsonPath().get("name"), Matchers.<Object>equalTo("Leanne Graham"));

    }
}
