package com.certification.wappi.questions;

import com.certification.wappi.userinterfaces.LoginComponents;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class TheLoginButton implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor) {
        return LoginComponents.BUTTON_LOGIN.resolveFor(actor).isEnabled();
    }
    public static TheLoginButton isEnable(){
        return new TheLoginButton();
    }
}
