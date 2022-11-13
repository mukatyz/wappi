package wappi.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;

public class WappiStepDefinitions {
    @Given("the user open the web pag")
    public void theUserOpenTheWebPag() {
        OnStage.theActorInTheSpotlight().attemptsTo(Open.url("http://automation-wappi.vercel.app/"));
    }
}
