package com.certification.wappi.tasks;

import com.certification.wappi.interactions.GoToTheOrdersScreen;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import java.util.List;

import static com.certification.wappi.userinterfaces.HomeComponents.*;
import static com.certification.wappi.utils.Constants.*;
import static com.certification.wappi.utils.Constants.COUPON_CODE;

public class MakeAnOrder implements Task {
    String productName;
    String withCoupon;

    public MakeAnOrder(String productName, String withCoupon) {
        this.productName = productName;
        this.withCoupon = withCoupon;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.remember(PRODUCT_NAME, this.productName);
        actor.attemptsTo(GoToTheOrdersScreen.andRememberInformation(this.productName));
        actor.attemptsTo(Click.on(ORDER_BUTTON.of(this.productName)));
        List<Object> productInformationList =  actor.recall(PRODUCT_INFORMATION_BEFORE);
        if(this.withCoupon.equals(WITH)){
            actor.attemptsTo(Enter.theValue(actor.recall(COUPON_CODE).toString()).into(COUPON_FIELD));
            productInformationList.add(YES);
            actor.remember(PRODUCT_INFORMATION_BEFORE, productInformationList);
        } else if (this.withCoupon.equals(WITH_INVALID)) {
            actor.attemptsTo(Enter.theValue(INVALID_CODE.toString()).into(COUPON_FIELD));
        }else {
            productInformationList.add(NO);
            actor.remember(PRODUCT_INFORMATION_BEFORE,productInformationList);
        }
        actor.attemptsTo(Click.on(SUBMIT_ORDER_BUTTON));
    }
    public static MakeAnOrder withTheParameters(String productName, String withCoupon){
        return Tasks.instrumented(MakeAnOrder.class, productName, withCoupon);
    }
}
