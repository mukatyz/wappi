package wappi.stepdefinitions.wappi;

import com.certification.wappi.exceptions.OrdersException;
import com.certification.wappi.interactions.CloseADialog;
import com.certification.wappi.questions.TheConfirmation;
import com.certification.wappi.questions.TheProductInformation;
import com.certification.wappi.tasks.MakeAnOrder;
import com.certification.wappi.tasks.TryToOrder;
import com.certification.wappi.userinterfaces.HomeComponents;
import com.certification.wappi.utils.Constants;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Click;

import static com.certification.wappi.userinterfaces.HomeComponents.*;
import static com.certification.wappi.utils.Constants.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.*;

public class OrdersStepDefinitions {
    @When("^try to order a (.*)$")
    public void tryToOrderAProduct(String productName) {
        theActorInTheSpotlight().attemptsTo(TryToOrder.aProduct(productName));
    }
    @When("^ordering (.*), (.*) coupon$")
    public void orderingSomethingWithCoupon(String productName, String withCoupon) {
        theActorInTheSpotlight().attemptsTo(MakeAnOrder.withTheParameters(productName, withCoupon));
    }
    @Then("the user should see the same product information in the dialog before to finish the order")
    public void theUserShouldSeeTheSameProductInformationInTheDialogBeforeToFinishTheOrder() {
        theActorInTheSpotlight().should(seeThat(TheProductInformation.obtained(PRODUCT_INFORMATION_DIALOG),
                is(equalTo(theActorInTheSpotlight().recall(PRODUCT_INFORMATION_BEFORE)))).
                orComplainWith(OrdersException.class, PRODUCT_INFORMATION_ERROR_MESSAGE));
    }
    @Then("Close the dialog coupone code")
    public void closeTheDialogCouponeCode(){
        theActorInTheSpotlight().attemptsTo(Click.on(CLOSE_DIALOG_ICON.of(ONE)));
    }
    @Then("the order should be done successfully")
    public void theOrderShouldBeDoneSuccessfully() {
        theActorInTheSpotlight().should(seeThat(TheConfirmation.message(HomeComponents.CONFIRMATION_ORDER_MESSAGE),
                is(equalTo(Constants.CONFIRMATION_ORDER_MESSAGE))).orComplainWith(OrdersException.class,ORDER_FINISHED_ERROR_MESSAGE));

    }
    @Then("The order information should appears in the orders screen")
    public void theOrderInformationShouldAppearsInTheOrdersScreen() {
        theActorInTheSpotlight().attemptsTo(CloseADialog.andOpenTheScreen(THREE, THREE));
        String productName = theActorInTheSpotlight().recall(PRODUCT_NAME);
        theActorInTheSpotlight().should(seeThat(TheProductInformation.obtained(GRID.of(productName)),
                is(equalTo(theActorInTheSpotlight().recall(PRODUCT_INFORMATION_BEFORE)))).
                orComplainWith(OrdersException.class, PRODUCT_INFORMATION_ERROR_MESSAGE));
    }
    @Then("the user should not see the product in the orders screen")
    public void theUserShouldNotSeeTheProductInTheOrdersScreen(){
        String productName = theActorInTheSpotlight().recall(PRODUCT_NAME);
        theActorInTheSpotlight().attemptsTo(CloseADialog.andOpenTheScreen(TWO,THREE));
        theActorInTheSpotlight().should(seeThat(TheProductInformation.obtained(GRID.of(productName)),
                is(empty())).orComplainWith(OrdersException.class, ORDER_UNSUCESSFUL_ERROR_MESSAGE));
    }
}
