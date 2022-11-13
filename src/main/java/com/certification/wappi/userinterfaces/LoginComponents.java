package com.certification.wappi.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginComponents {
    public static final Target USERNAME = Target.the("Username field used in the login page").
            located(By.id("username"));
    public static final Target ERROR_MESSAGE = Target.the("Error message in the login page fields").
            locatedBy("//*[@id='e-{0}']");
    public static final Target PASSWORD = Target.the("Password field used in the login page").
            located(By.id("password"));
    public static final Target BUTTON_LOGIN = Target.the("Button login").
            located(By.id("button-login"));
}
