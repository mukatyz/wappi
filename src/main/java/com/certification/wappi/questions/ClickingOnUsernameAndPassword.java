package com.certification.wappi.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import static com.certification.wappi.userinterfaces.LoginComponents.PASSWORD;
import static com.certification.wappi.userinterfaces.LoginComponents.USERNAME;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ClickingOnUsernameAndPassword implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(USERNAME),
                Click.on(PASSWORD),
                Click.on(USERNAME));
    }
    public static ClickingOnUsernameAndPassword inTheLoginSreen(){
        return Tasks.instrumented(ClickingOnUsernameAndPassword.class);
    }
}
