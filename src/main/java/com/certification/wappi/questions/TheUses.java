package com.certification.wappi.questions;

import com.certification.wappi.userinterfaces.HomeComponents;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class TheUses implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {
        return Text.ofEach(HomeComponents.COUPONES_INFORMATION).answeredBy(actor).toArray()[3].toString();
    }
    public static TheUses ofTheCoupon(){
        return new TheUses();
    }
}
