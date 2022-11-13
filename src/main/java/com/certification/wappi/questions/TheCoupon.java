package com.certification.wappi.questions;

import com.certification.wappi.userinterfaces.HomeComponents;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class TheCoupon implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor) {
        return HomeComponents.COUPON_CODE.resolveFor(actor).isVisible();
    }
    public static TheCoupon isVisible(){

        return new TheCoupon();
    }
}
