package com.certification.wappi.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;

import java.util.Arrays;
import java.util.List;


public class TheProductInformation implements Question<List<Object>> {
    private final Target targetValidaion;

    public TheProductInformation(Target targetValidaion) {
        this.targetValidaion = targetValidaion;
    }

    @Override
    public List<Object> answeredBy(Actor actor) {
        return Arrays.asList(Text.ofEach(targetValidaion).answeredBy(actor).toArray());

    }
    public static TheProductInformation obtained(Target targetValidaion){
        return new TheProductInformation(targetValidaion);
    }

}
