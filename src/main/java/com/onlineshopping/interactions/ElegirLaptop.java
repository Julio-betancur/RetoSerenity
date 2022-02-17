package com.onlineshopping.interactions;

import com.onlineshopping.globalvar.GlobarVars;
import com.onlineshopping.userinterface.ListaLaptosUI;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.targets.Target;

import java.util.List;

public class ElegirLaptop implements Interaction {

    public ElegirLaptop() {
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        //Creo lista de elementos y los obtengo del Target
        List<WebElementFacade> listaLaptops = ListaLaptosUI.BTN_COMPRAR_LAPTOS.resolveAllFor(actor);

        //Guardo el tercer elemento de la lista anterior en una variable global
        GlobarVars.element = listaLaptops.get(2);

        actor.attemptsTo(
                GuardarLabel.on(GlobarVars.element)
        );


    }

    public static ElegirLaptop on() {
        return Instrumented.instanceOf(ElegirLaptop.class).withProperties();
    }
}
