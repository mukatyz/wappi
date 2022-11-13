package com.certification.wappi.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.questions.Text;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.certification.wappi.userinterfaces.HomeComponents.BANNER_BUTTONS;
import static com.certification.wappi.userinterfaces.HomeComponents.GRID;
import static com.certification.wappi.utils.Constants.*;

public class GoToTheOrdersScreen implements Interaction {
    private String productName;

    public GoToTheOrdersScreen(String productName) {
        this.productName = productName;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(BANNER_BUTTONS.of(ONE)));
        List<Object> productInformationList = Arrays.stream(Text.ofEach(GRID.of(this.productName)).answeredBy(actor).toArray()).filter(e->!e.equals(ORDER)).collect(Collectors.toList());
        actor.remember(PRODUCT_INFORMATION_BEFORE,productInformationList);
    }
    public static GoToTheOrdersScreen andRememberInformation(String productName){
        return Tasks.instrumented(GoToTheOrdersScreen.class, productName);
    }


}
