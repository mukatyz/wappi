package com.certification.wappi.questions;

import com.certification.wappi.userinterfaces.ProfileComponents;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Upload;
import net.serenitybdd.screenplay.ui.Select;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

import static com.certification.wappi.userinterfaces.ProfileComponents.*;
import static com.certification.wappi.utils.Constants.*;
import static com.certification.wappi.utils.Constants.IMAGE;
import static com.certification.wappi.utils.Constants.SEX_RADIO;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class EnterThe implements Task {
    private final List<List<String>> profileInformationAsList;

    public EnterThe(List<List<String>> profileInformationAsList) {
        this.profileInformationAsList = profileInformationAsList;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        int i = 0;
        for (String field :
                this.profileInformationAsList.get(0)) {
            switch (field) {
                case (IMAGE):
                    if (!Objects.equals(this.profileInformationAsList.get(1).get(i), "null")) {
                        String file = "src\\test\\resources\\files\\" + this.profileInformationAsList.get(1).get(i);
                        Path path = Paths.get(file).toAbsolutePath();
                        theActorInTheSpotlight().attemptsTo(Upload.theFile(path).to(ProfileComponents.IMAGE));//this is the line which is giving errors
                    }
                    break;
                case (COUNTRY):
                    actor.attemptsTo(Select.option(this.profileInformationAsList.get(1).get(i)).from(PROFILE_FIELDS.of(COUNTRY)));
                    break;
                case (SEX_RADIO):
                    if (!Objects.equals(this.profileInformationAsList.get(1).get(i), "null"))
                        actor.attemptsTo(Click.on(ProfileComponents.SEX_RADIO.of(this.profileInformationAsList.get(1).get(i))));
                    break;
                default:
                    actor.attemptsTo(Enter.theValue(this.profileInformationAsList.get(1).get(i)).into(PROFILE_FIELDS.of(field)));
                    break;
            }
            i++;
        }

    }


    public static EnterThe profileInformation(List<List<String>> profileInformationAsList) {
        return Tasks.instrumented(EnterThe.class, profileInformationAsList);
    }
}
