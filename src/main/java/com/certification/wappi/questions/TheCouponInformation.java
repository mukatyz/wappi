package com.certification.wappi.questions;

import com.certification.wappi.userinterfaces.HomeComponents;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class TheCouponInformation implements Question<Object[]> {
    @Override
    public Object[] answeredBy(Actor actor) {
        return Text.ofEach(HomeComponents.COUPONES_INFORMATION).answeredBy(actor).toArray();
    }
    public static TheCouponInformation inTheGrid(){
        return new TheCouponInformation();
    }
}
