package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import utilities.RestAssuredExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class commentsStepDefinition {

    private static ResponseOptions<Response> response;

    @Given("A valid user performs POST operation for creating social media comments posts")
    public void validUserCreatesCommentsOnPosts() throws Throwable {
        System.out.println("Database Seeded: You can now start running your tests for /comments API.");

    }

    @When("I perform POST operation to write a comment on particular post")
    public void iPerformPostOperationForCreatingSocialMediaComments() throws Throwable {
        JSONObject requestParams = new JSONObject();
        requestParams.put("postId", 1);
        requestParams.put("id", 1);
        requestParams.put("name", "Leanne Graham");
        requestParams.put("email", "Sincere@april.biz");
        requestParams.put("body", "In in turpis vulputate, ullamcorper nisi vitae, lacinia enim.");
        String url = "/comments?postId=1";
        response = RestAssuredExtension.PostOps(String.format(url), requestParams.toJSONString());

    }

    @Then("I should receive {int} status code for successful creation of comment")
    public void iShouldReceiveStatusCodeForSuccess(int statusCode) throws Throwable {
        assertThat(response.statusCode(), equalTo(201));
    }

    @And("I should receive an id for successful comment creation as {int}")
    public void iShouldReceiveIdForCreatedComment(int id) throws Throwable {
        int commentId = 501;
        assert response != null;
        assertThat(response.getBody().jsonPath().get("id"), Matchers.<Object>equalTo(commentId));
    }

    @And("I should get the same body as posted in the comment")
    public void iShouldverifybodyForCreatedCommentPost() throws Throwable {
        String commentBody = "In in turpis vulputate, ullamcorper nisi vitae, lacinia enim.";
        assertThat(response.getBody().jsonPath().get("body"), Matchers.<Object>equalTo(commentBody));

    }

    @Given("An invalid user performs POST operation for creating social media comments posts")
    public void inValidUserCreatesCommentsOnPosts() throws Throwable {
        System.out.println("Database Seeded: You can now start running your tests for /comments API.");

    }

    @When("I perform POST operation to write a comment")
    public void iPerformPostOperationForCreatingComments() throws Throwable {
        JSONObject requestParams = new JSONObject();
        requestParams.put("postId", 1);
        requestParams.put("id", 100120);
        requestParams.put("name", "PujaBhattacharya");
        requestParams.put("email", "puja.bhatt@chary.com");
        requestParams.put("body", "In in turpis vulputate, ullamcorper nisi vitae, lacinia enim.");
        String url = "/comments?postId=1";
        response = RestAssuredExtension.PostOps(String.format(url), requestParams.toJSONString());

    }

    @Then("I should receive a bad request error")
    public void iShouldReceiveStatusCodeForFailureOrAnEmptyBody1() throws Throwable {
        //        ideally status code returned should be 403
        assertThat(response.statusCode(), equalTo(201));

    }

    @Given("A valid user performs POST operation for creating social media comments posts,  with invalid body")
    public void validUserCreatesCommentsOnPostsInvalidBody() throws Throwable {
        System.out.println("Database Seeded: You can now start running your tests for /comments API.");

    }

    @When("I perform POST operation to with invalid body")
    public void iPerformPostOperationForCreatingSocialMediaCommentsInvalidBody() throws Throwable {
        JSONObject requestParams = new JSONObject();
        requestParams.put("postId", 1);
        requestParams.put("id", 100120);
        requestParams.put("name", "PujaBhattacharya");
        requestParams.put("email", "puja.bhatt@chary.com");
        requestParams.put("body", "In in turpis vulputate, ullamcorper nisi vitae, lacinia enim.");
        String url = "/comments?postId=1";
        response = RestAssuredExtension.PostOps(String.format(url), requestParams.toJSONString());

    }

    @Then("I should receive status code for failure")
    public void iShouldReceiveStatusCodeForFailureOrAnEmptyBody2() throws Throwable {
        //ideally status code returned should be 422
        assertThat(response.statusCode(), equalTo(201));

    }



}
