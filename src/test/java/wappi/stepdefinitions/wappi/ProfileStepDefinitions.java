package wappi.stepdefinitions.wappi;

import com.certification.wappi.exceptions.ProfileException;
import com.certification.wappi.questions.TheProfileInformation;
import com.certification.wappi.questions.EnterThe;
import com.certification.wappi.questions.TheConfirmation;
import com.certification.wappi.questions.TheProfile;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.*;

import java.util.Arrays;
import java.util.List;

import static com.certification.wappi.userinterfaces.HomeComponents.BANNER_BUTTONS;
import static com.certification.wappi.userinterfaces.HomeComponents.CLOSE_DIALOG_ICON;
import static com.certification.wappi.userinterfaces.ProfileComponents.*;
import static com.certification.wappi.utils.Constants.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.*;

public class ProfileStepDefinitions {

    @When("Go to profile screen")
    public void goToProfileScreen() {
        theActorInTheSpotlight().attemptsTo(Click.on(BANNER_BUTTONS.of(FOUR)));
    }

    @Then("the user should see the fields with information")
    public void theUserShouldSeeTheFieldsWithInformation() {
        theActorInTheSpotlight().should(seeThat(TheProfileInformation.list(), not(containsInAnyOrder(nullValue()))).
                orComplainWith(ProfileException.class, FIELDS_INFORMATION_ERROR_MESSGE));
    }
    @When("the user save the profile information")
    public void theUserSaveTheProfileInformation() {
        theActorInTheSpotlight().attemptsTo(Click.on(SAVE_PROFILE_BUTTON));
    }
    @When("the user do not save the profile information")
    public void theUserDoNotSaveTheProfileInformation() {
        theActorInTheSpotlight().attemptsTo(Click.on(CANCEL_PROFILE_BUTTON));
    }
    @When("^enter the information in the fields$")
    public void enterTheInformationInThefields(io.cucumber.datatable.DataTable profileInformation) {
        List<List<String>> profileInformationAsList = profileInformation.asLists(String.class);
        theActorInTheSpotlight().attemptsTo(EnterThe.profileInformation(profileInformationAsList));
        theActorInTheSpotlight().remember("profileInformationAsList", profileInformationAsList.get(Integer.parseInt(ONE)));
    }
    @Then("^the user should see the error message under the fields$")
    public void theUserShouldSeeTheErrorMessageUnderTheFields() {
        theActorInTheSpotlight().should(seeThat(TheProfile.errorMessage(), is(equalTo(ERROR_MESSAGE_PROFILE))).
                orComplainWith(ProfileException.class, VALIDATION_PROFILE_ERROR_MESSAGE));
    }
    @Then("should see the confirmation message")
    public void shouldSeeTheConfirmationMessage() {
        theActorInTheSpotlight().should(seeThat(TheConfirmation.message(CONFIRMATION_MODAL_MESSAGE),
                is(equalTo(CONFIRMATION_SAVE_PROFILE_INFORMATION))).orComplainWith(ProfileException.class, CONFIRMATION_PROFILE_ERROR_MESSAGE));
    }
    @When("go out and come back to the profile screen")
    public void goOutAndComeBackToTheProfileScreen() {
        theActorInTheSpotlight().attemptsTo(Click.on(CLOSE_DIALOG_ICON.of(TWO)),
                Click.on(BANNER_BUTTONS.of(ONE)),
                Click.on(BANNER_BUTTONS.of(FOUR)));
    }
    @Then("the user should see the last profile information saved")
    public void theUserShouldSeeTheLastProfileInformationSaved() {
        theActorInTheSpotlight().should(seeThat(TheProfileInformation.list(), is(equalTo(theActorInTheSpotlight().
                recall(PROFILE_INFORMATION)))).orComplainWith(ProfileException.class, PROFILE_INFORMATION_SAVED_ERROR_MESSAGE));
    }
    @Then("the user should see the profile information for default")
    public void theUserShouldSeeTheProfileInformationForDefault() {
        theActorInTheSpotlight().should(seeThat(TheProfileInformation.list(),
                is(equalTo(Arrays.asList(MAIN_PROFILE_INFORMATION)))).orComplainWith(ProfileException.class, VALIDATION_CANCEL_BUTTON));
    }
}
