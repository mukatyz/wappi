package wappi.stepdefinitions.wappi;

import com.certification.wappi.exceptions.CouponException;
import com.certification.wappi.interactions.CloseADialog;
import com.certification.wappi.questions.*;
import com.certification.wappi.tasks.ClaimingTheWelcomeCoupon;
import com.certification.wappi.tasks.EnterTheUSernameAndPAssword;
import com.certification.wappi.utils.Constants;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Click;

import static com.certification.wappi.userinterfaces.HomeComponents.*;
import static com.certification.wappi.userinterfaces.LoginComponents.BUTTON_LOGIN;
import static com.certification.wappi.utils.Constants.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class CouponStepDefinitions {
    @Given("^the user login with the user (.*) and password (.*)$")
    public void theUserLoginWithTheUserAndPassword(String username, String password) {
        theActorInTheSpotlight().attemptsTo(EnterTheUSernameAndPAssword.inTheLoginFields(username, password),
                Click.on(BUTTON_LOGIN));
    }
    @Then("the user should see the welcome coupon")
    public void theUserShouldSeeTheWelcomeCoupon() {
        theActorInTheSpotlight().should(seeThat(TheConfirmation.message(WELCOME_COUPON_MESSAGE), is(equalTo(COUPON_MESSAGE))));
    }
    @Then("the coupon code should be showed")
    public void theCouponCodeShouldBeShowed() {
        theActorInTheSpotlight().should(seeThat(TheCoupon.isVisible(), is(equalTo(TRUE))).orComplainWith(CouponException.class, COUPON_CODE_ERROR_MESSAGE));
    }
    @When("claiming the welcome coupon")
    public void claimingTheWelcomeCoupon() {
        theActorInTheSpotlight().attemptsTo(ClaimingTheWelcomeCoupon.code());
    }

    @When("Go to the orders page")
    public void goToTheOrdersPage(){
        theActorInTheSpotlight().attemptsTo(Click.on(CLOSE_DIALOG_ICON.of(ONE)));
    }
    @Then("the coupon information should be right")
    public void theCouponInformationShouldBeRight() {
        String couponCode = theActorInTheSpotlight().recall(Constants.COUPON_CODE);
        String[] couponInformation = {couponCode, "31/12/2022", "Cupón de Bienvenida", "1"};
        theActorInTheSpotlight().should(seeThat(TheCouponInformation.inTheGrid(), is(equalTo(couponInformation))).
                orComplainWith(CouponException.class, COUPON_INFORMATION_ERROR_MESSAGE));
    }
    @Then("the coupon uses should be {int}")
    public void theCouponUsesShouldBe(Integer couponesCount) {
        theActorInTheSpotlight().attemptsTo(CloseADialog.andOpenTheScreen(THREE,TWO));
        theActorInTheSpotlight().should(seeThat(TheUses.ofTheCoupon(), is(equalTo(couponesCount))).
                orComplainWith(CouponException.class, NUMBER_OF_COUPON_ERROR_MESSAGE));
    }
    @When("the user log out")
    public void theUserLogOut() {
        theActorInTheSpotlight().attemptsTo(Click.on(CLOSE_DIALOG_ICON.of(ONE)),
                Click.on(BANNER_BUTTONS.of(FIVE)));
    }
    @When("login again")
    public void loginAgain() {
        theActorInTheSpotlight().attemptsTo(EnterTheUSernameAndPAssword.inTheLoginFields(
                theActorInTheSpotlight().recall(Constants.USERNAME), theActorInTheSpotlight().recall(PASSWORD)),
                Click.on(BUTTON_LOGIN));
    }
    @Then("the welcome coupon shouldn't appears")
    public void theWelcomeCouponShouldnTAppears() {
        theActorInTheSpotlight().should(seeThat(TheWelcomeCouponButton.isVisible(), is(equalTo(FALSE))).
                orComplainWith(CouponException.class, WELCOME_COUPON_BUTTON_ERROR_MESSAGE));
    }

}
