package com.certification.wappi.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class TheConfirmation implements Question<String> {
    private final Target target;

    public TheConfirmation(Target target) {
        this.target = target;
    }

    @Override
    public String answeredBy(Actor actor) {
        actor.attemptsTo(WaitUntil.the(target, WebElementStateMatchers.isVisible()));
        return Text.of(this.target).answeredBy(actor).toString();
    }
    public static TheConfirmation message(Target targetConfirmation){
        return new TheConfirmation(targetConfirmation);
    }
}
