package com.automation.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;
import java.util.Map;

public class RegisterUser implements Task {

    private final Map<String, String> userDetails;

    public RegisterUser(Map<String, String> userDetails) {
        this.userDetails = userDetails;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to("/register")
                        .with(request -> request
                                .header("Content-Type", "application/json")
                                .body(userDetails)
                        )
        );
    }

    public static RegisterUser withDetails(Map<String, String> userDetails) {
        return new RegisterUser(userDetails);
    }
}
