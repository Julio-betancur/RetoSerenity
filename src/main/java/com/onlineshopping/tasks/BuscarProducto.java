package com.onlineshopping.tasks;

import com.onlineshopping.globalvar.GlobarVars;
import com.onlineshopping.interactions.ElegirLaptop;
import com.onlineshopping.userinterface.HomeUI;
import com.onlineshopping.userinterface.LaptopUI;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.serenitybdd.screenplay.waits.Wait;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class BuscarProducto implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(HomeUI.BTN_LAPTOS),
                ElegirLaptop.on()

        );
        GlobarVars.element.click();
        actor.attemptsTo(
                Wait.until(WebElementQuestion.the(LaptopUI.LBL_NOMBRE_LAPTOP), WebElementStateMatchers.isEnabled()).forNoLongerThan(10).seconds()
        );


    }

    public static BuscarProducto on() {
        return Instrumented.instanceOf(BuscarProducto.class).withProperties();
    }
}
