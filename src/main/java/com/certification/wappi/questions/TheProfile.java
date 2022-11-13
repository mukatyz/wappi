package com.certification.wappi.questions;

import com.certification.wappi.userinterfaces.ProfileComponents;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
public class TheProfile implements Question<Object[]> {
    @Override
    public Object[] answeredBy(Actor actor) {
        return Text.ofEach(ProfileComponents.ERROR_MESAGE_PROFILE).answeredBy(actor).toArray();
    }
    public static TheProfile errorMessage(){
        return new TheProfile();
    }
}
