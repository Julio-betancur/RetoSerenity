package com.onlineshopping.tasks;

import com.onlineshopping.interactions.GuardarLabel;
import com.onlineshopping.userinterface.HomeUI;
import com.onlineshopping.userinterface.LaptopUI;
import com.onlineshopping.userinterface.OrdenPagoUI;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.serenitybdd.screenplay.waits.Wait;

public class ComprarProducto implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(LaptopUI.BTN_GUARDAR_LAPTOP),
                Wait.until(WebElementQuestion.the(LaptopUI.BTN_IR_PAGAR), WebElementStateMatchers.isClickable()).forNoLongerThan(10).seconds(),
                Click.on(LaptopUI.BTN_IR_PAGAR),
                Wait.until(WebElementQuestion.the(OrdenPagoUI.LBL_NOMBRE_LAPTOP), WebElementStateMatchers.isEnabled()).forNoLongerThan(10).seconds()
        );
    }

    public static ComprarProducto on() {
        return Instrumented.instanceOf(ComprarProducto.class).withProperties();
    }
}
