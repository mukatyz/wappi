package com.certification.wappi.tasks;

import com.certification.wappi.interactions.GoToTheOrdersScreen;
import com.certification.wappi.utils.Constants;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.questions.Text;

import java.util.Arrays;

import static com.certification.wappi.userinterfaces.HomeComponents.*;
import static com.certification.wappi.userinterfaces.HomeComponents.PRODUCT_INFORMATION_DIALOG;

public class TryToOrder implements Task {
    private final String productName;

    public TryToOrder(String productName) {
        this.productName = productName;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(GoToTheOrdersScreen.andRememberInformation(this.productName));
        actor.attemptsTo(Click.on(ORDER_BUTTON.of(this.productName)));
        actor.remember(Constants.PRODUCT_INFORMATION_BEFORE, Arrays.asList(Text.ofEach(PRODUCT_INFORMATION_DIALOG).answeredBy(actor).toArray()));
    }
    public static TryToOrder aProduct(String productName){
        return Tasks.instrumented(TryToOrder.class, productName);
    }
}
