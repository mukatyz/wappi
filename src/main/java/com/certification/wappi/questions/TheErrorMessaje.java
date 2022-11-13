package com.certification.wappi.questions;


import com.certification.wappi.userinterfaces.LoginComponents;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class TheErrorMessaje implements Question<String> {
    private final String field;

    public TheErrorMessaje(String field) {
        this.field = field;
    }

    @Override
    public String answeredBy(Actor actor) {

        return Text.of(LoginComponents.ERROR_MESSAGE.of(this.field)).answeredBy(actor).toString();
    }
    public static TheErrorMessaje obtained(String field){
        return new TheErrorMessaje(field);
    }
}
