package com.onlineshopping.interactions;

import com.onlineshopping.globalvar.GlobarVars;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;


public class GuardarLabel implements Interaction {

    private WebElementFacade elementFacade;


    public GuardarLabel(WebElementFacade elementFacade) {
        this.elementFacade = elementFacade;
    }


    @Override
    public <T extends Actor> void performAs(T actor) {

            GlobarVars.randomModel = elementFacade.getText();

    }

    public static Performable on(WebElementFacade elementFacade) {
        return Instrumented.instanceOf(GuardarLabel.class).withProperties(elementFacade);
    }


}

