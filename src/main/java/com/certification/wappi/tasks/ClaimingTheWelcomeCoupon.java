package com.certification.wappi.tasks;

import com.certification.wappi.questions.TheConfirmation;
import com.certification.wappi.questions.TheWelcomeCouponButton;
import com.certification.wappi.userinterfaces.HomeComponents;
import com.certification.wappi.utils.Constants;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.questions.Text;

import static com.certification.wappi.userinterfaces.HomeComponents.*;
import static com.certification.wappi.utils.Constants.COUPON_MESSAGE;
import static com.certification.wappi.utils.Constants.ONE;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class ClaimingTheWelcomeCoupon implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.should(seeThat(TheWelcomeCouponButton.isVisible(), is(equalTo(true))));
        actor.attemptsTo(Click.on(HomeComponents.WELCOME_COUPON_BUTTON));
        actor.should(seeThat(TheConfirmation.message(WELCOME_COUPON_MESSAGE), is(equalTo(COUPON_MESSAGE))));
        actor.remember(Constants.COUPON_CODE, Text.of(COUPON_CODE).answeredBy(actor).toString());
    }
    public static ClaimingTheWelcomeCoupon code(){
        return Tasks.instrumented(ClaimingTheWelcomeCoupon.class);
    }
}
