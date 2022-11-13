package com.certification.wappi.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.ArrayList;
import java.util.List;

import static com.certification.wappi.userinterfaces.ProfileComponents.*;
import static com.certification.wappi.utils.Constants.FEMALE;
import static com.certification.wappi.utils.Constants.MALE;

public class TheProfileInformation implements Question<List<Object>> {
    @Override
    public List<Object> answeredBy(Actor actor) {
        ArrayList<Object> informationList = new ArrayList<>();
        informationList.add(PROFILE_FIELDS.of("image").resolveFor(actor).getValue());
        informationList.add(PROFILE_FIELDS.of("name").resolveFor(actor).getValue());
        informationList.add(PROFILE_FIELDS.of("lastName").resolveFor(actor).getValue());
        informationList.add(PROFILE_FIELDS.of("bornDate").resolveFor(actor).getValue());
        informationList.add(PROFILE_FIELDS.of("country").resolveFor(actor).getSelectedVisibleTextValue());
        if (SEX_RADIO.of(MALE).resolveFor(actor).isSelected())
            informationList.add(MALE);
        else
            informationList.add(FEMALE);
        return informationList;
    }
    public static TheProfileInformation list(){
        return new TheProfileInformation();
    }
}
