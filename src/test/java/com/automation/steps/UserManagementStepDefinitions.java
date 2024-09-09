package com.automation.steps;

import com.automation.tasks.ListUsers;
import com.automation.tasks.RegisterUser;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.rest.questions.LastResponse;
import java.util.Map;

public class UserManagementStepDefinitions {

    @Given("the API is available")
    public void theApiIsAvailable() {
        OnStage.theActorCalled("User").whoCan(CallAnApi.at("https://reqres.in/api"));
    }

    @When("I request the list of users")
    public void iRequestTheListOfUsers() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                ListUsers.fromAPI()
        );
    }

    @Then("I should see at least one user in the response")
    public void iShouldSeeAtLeastOneUserInTheResponse() {
        OnStage.theActorInTheSpotlight().should(
                Ensure.that(LastResponse.received().body("data", hasSize(greaterThan(0))))
        );
    }

    @When("I register a new user with valid details")
    public void iRegisterANewUserWithValidDetails(Map<String, String> userDetails) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                RegisterUser.withDetails(userDetails)
        );
    }

    @Then("I should see the user registered successfully")
    public void iShouldSeeTheUserRegisteredSuccessfully() {
        OnStage.theActorInTheSpotlight().should(
                Ensure.that(LastResponse.received().statusCode()).isEqualTo(200)
        );
    }
}
