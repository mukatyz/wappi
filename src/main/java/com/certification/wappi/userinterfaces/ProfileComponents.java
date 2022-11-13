package com.certification.wappi.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ProfileComponents {
    public static final Target PROFILE_SCREEN = Target.the("profile screen").
            locatedBy("//*[@class='profile-content']");
    public static final Target PROFILE_FIELDS = Target.the("{0} field in profile screen").
            locatedBy("//*[@id='{0}']");
    public static final Target SEX_RADIO = Target.the("Sex radio in profile screen").
            locatedBy("//*[@class='radio-label' and text()='{0}']//parent::label");
    public static final Target SEX_RADIO_SELECTOR = Target.the("Sex radio selector").
            locatedBy("//*[@type='radio']");

    public static final Target PROFILE_FIELDS_LIST = Target.the("Profile information list").
            locatedBy("//*[@class='input ng-untouched ng-pristine ng-valid']");
    public static final Target SAVE_PROFILE_BUTTON = Target.the("Save profile button").
            located(By.id("save-profile"));
    public static final Target CANCEL_PROFILE_BUTTON = Target.the("Save profile button").
            located(By.id("cancel-changes"));
    public static final Target IMAGE = Target.the("Choose image button").
            locatedBy("//*[@type='file']");
    public static final Target ERROR_MESAGE_PROFILE = Target.the("Error message in the profile fields").
            locatedBy("//*[@class='error-message']");
    public static final Target CONFIRMATION_MODAL_MESSAGE = Target.the("Confirmation modal message")
            .locatedBy("//*[@class='confirmation-modal-info']");
}
