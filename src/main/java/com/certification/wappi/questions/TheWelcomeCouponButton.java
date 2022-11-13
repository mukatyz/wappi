package com.certification.wappi.questions;

import com.certification.wappi.userinterfaces.HomeComponents;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.certification.wappi.userinterfaces.HomeComponents.WELCOME_COUPON_BUTTON;

public class TheWelcomeCouponButton implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor) {
        actor.attemptsTo(WaitUntil.the(WELCOME_COUPON_BUTTON, WebElementStateMatchers.isVisible()));
        return WELCOME_COUPON_BUTTON.resolveFor(actor).isVisible();
    }
    public static TheWelcomeCouponButton isVisible(){
        return new TheWelcomeCouponButton();
    }
}
