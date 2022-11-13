package com.certification.wappi.questions;

import com.certification.wappi.userinterfaces.HomeComponents;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class TheHomeButton implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor) {
        return HomeComponents.HOME_TITLE.resolveFor(actor).isVisible();
    }
    public static TheHomeButton isVisible(){
        return new TheHomeButton();
    }
}
