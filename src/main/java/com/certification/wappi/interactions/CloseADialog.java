package com.certification.wappi.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;

import static com.certification.wappi.userinterfaces.HomeComponents.BANNER_BUTTONS;
import static com.certification.wappi.userinterfaces.HomeComponents.CLOSE_DIALOG_ICON;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class CloseADialog implements Interaction {
    private String closeDialogOption;
    private String bannerOption;


    public CloseADialog(String closeDialogOption, String bannerOption) {
        this.closeDialogOption = closeDialogOption;
        this.bannerOption = bannerOption;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        theActorInTheSpotlight().attemptsTo(Click.on(CLOSE_DIALOG_ICON.of(this.closeDialogOption)));
        theActorInTheSpotlight().attemptsTo(Click.on(BANNER_BUTTONS.of(this.bannerOption)));
    }
    public static CloseADialog andOpenTheScreen(String closeDialogOption, String bannerOption){
        return new CloseADialog(closeDialogOption, bannerOption);
    }
}
