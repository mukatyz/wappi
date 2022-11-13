package wappi.stepdefinitions.wappi;

import io.cucumber.java.Before;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static com.certification.wappi.utils.Constants.USERNAME_ENVIRONMENT;

public class EnvironmentStepDefinitios {
    @Before
    public void setUpStage() {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled(USERNAME_ENVIRONMENT);
    }
}

