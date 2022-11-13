package com.certification.wappi.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HomeComponents {
    public static final Target HOME_TITLE = Target.the("Home title").
            locatedBy("//*[@class = 'app-title']");
    public static final Target WELCOME_COUPON_BUTTON = Target.the("Welcome coupon button").
            located(By.id("welcome-coupon"));
    public static final Target WELCOME_COUPON_MESSAGE = Target.the("Welcome coupon message").
            locatedBy("//*[@class = 'modal-content']//p");
    public static final Target COUPON_CODE = Target.the("Coupon code").
            located(By.id("coupon-code"));
    public static final Target COUPONES_INFORMATION = Target.the("Coupones information").
            locatedBy("//*[@id = 'coupon-0']//*");
    public static final Target CLOSE_DIALOG_ICON = Target.the("Close coupon code icon").
            locatedBy("(//*[@class='close'])[{0}]");

    public static final Target BANNER_BUTTONS = Target.the("Home button in the banner").
            locatedBy("(//*[contains(@class,'nav-bar-link')])[{0}]");
    public static final Target ORDER_BUTTON = Target.the("Order button foran specific product").
            locatedBy("//*[text()='{0}']//parent::tr//*[@class = 'button success offers-table-block-button']");
    public static final Target MODAL = Target.the("Modal").
            locatedBy("//*[@class='modal opened']");
    public static final Target COUPON_FIELD = Target.the("Coupon field in the order").
            located(By.id("coupon"));
    public static final Target SUBMIT_ORDER_BUTTON = Target.the("Submit order button").
            located(By.id("order-confirm"));
    public static final Target PRODUCT_INFORMATION_DIALOG = Target.the("Product information in the dialod").
            locatedBy("//*[@class='offer-main-info' or @class='offer-info']//span");
    public static final Target CONFIRMATION_ORDER_MESSAGE = Target.the("Confirmation order message").
            locatedBy("//*[@class='confirmation-modal-info']");
    public static final Target GRID = Target.the("Offers and orders grid").
            locatedBy("//td[contains(text(),'{0}')]//parent::tr//td");
}
