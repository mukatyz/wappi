package com.certification.wappi.tasks;

import com.certification.wappi.utils.Constants;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;

import static com.certification.wappi.userinterfaces.LoginComponents.PASSWORD;
import static com.certification.wappi.userinterfaces.LoginComponents.USERNAME;

public class EnterTheUSernameAndPAssword implements Task {
    private final String userName;
    private final String password;

    public EnterTheUSernameAndPAssword(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Enter.theValue(this.userName).into(USERNAME));
        actor.attemptsTo(Enter.theValue(this.password).into(PASSWORD));
        actor.remember(Constants.USERNAME, this.userName);
        actor.remember(Constants.PASSWORD, this.password);
    }
    public static EnterTheUSernameAndPAssword inTheLoginFields(String userName, String password){
        return Tasks.instrumented(EnterTheUSernameAndPAssword.class, userName,password);
    }


}