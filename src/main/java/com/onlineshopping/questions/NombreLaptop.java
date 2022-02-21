package com.onlineshopping.questions;

import com.onlineshopping.userinterface.OrdenPagoUI;
import net.serenitybdd.core.pages.WithByLocator;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class NombreLaptop implements Question<String> {

    public static Question<String> value(){
        return new NombreLaptop();
    }

    @Override
    public String answeredBy(Actor actor) {
        return OrdenPagoUI.LBL_NOMBRE_LAPTOP.resolveFor(actor).getText();
    }

}
