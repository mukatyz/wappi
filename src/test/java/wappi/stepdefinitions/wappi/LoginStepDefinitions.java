package wappi.stepdefinitions.wappi;

import com.certification.wappi.exceptions.LoginException;
import com.certification.wappi.questions.ClickingOnUsernameAndPassword;
import com.certification.wappi.questions.TheHomeButton;
import com.certification.wappi.questions.TheLoginButton;
import com.certification.wappi.questions.TheErrorMessaje;
import com.certification.wappi.tasks.EnterTheUSernameAndPAssword;
import com.certification.wappi.utils.Constants;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Click;
import org.hamcrest.Matchers;

import static com.certification.wappi.userinterfaces.LoginComponents.*;
import static com.certification.wappi.utils.Constants.*;
import static com.certification.wappi.utils.Constants.ERROR_MESSAGE;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class LoginStepDefinitions {

    @When("^clicking on the username and password fields$")
    public void clickingOnTheUsernameAndPasswordFields() {
        theActorInTheSpotlight().attemptsTo(ClickingOnUsernameAndPassword.inTheLoginSreen());
    }
    @Then("^the user should see the error message under the (.*) field: (.*)$")
    public void theUserShouldSeeTheErrorMessage(String field,String errorMessage) {
        theActorInTheSpotlight().should(seeThat(TheErrorMessaje.obtained(field), is(Matchers.equalTo(errorMessage))).
                orComplainWith(LoginException.class, VALIDATION_FIELDS_ERROR_MESSAGE.replace(ERROR_MESSAGE, errorMessage).replace(FIELD, field)));
    }

    @When("^enter the user (.*) and password (.*)$")
    public void enterTheUserMukatyzAndPasswordMukatyz(String username, String password) {
        theActorInTheSpotlight().attemptsTo(EnterTheUSernameAndPAssword.inTheLoginFields(username,password));
    }

    @Then("^the user should disabled the login button$")
    public void theUserShouldDisabledTheLoginButton() {
        theActorInTheSpotlight().should(seeThat(TheLoginButton.isEnable(), is(Matchers.equalTo(FALSE))).
                orComplainWith(LoginException.class,DISABLE_LOGIN_BUTTON_ERROR_MESSAGE));
    }
    @When("^clicking on login button$")
    public void clickingOnLoginButton() {
        theActorInTheSpotlight().attemptsTo(Click.on(BUTTON_LOGIN));
    }
    @Then("^the user should see the main page$")
    public void theUserShouldSeeTheMainPage() {
        theActorInTheSpotlight().should(seeThat(TheHomeButton.isVisible(), is(equalTo(TRUE))).
                orComplainWith(LoginException.class, MAIN_PAGE_ERROR_MESSAGE));
    }

}
