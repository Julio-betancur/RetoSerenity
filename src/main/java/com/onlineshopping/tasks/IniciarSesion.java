package com.onlineshopping.tasks;

import com.onlineshopping.interactions.GuardarLabel;
import com.onlineshopping.userinterface.HomeUI;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;

public class IniciarSesion implements Task {

    private String usuario;
    private String clave;

    public IniciarSesion(String usuario, String clave) {
        this.usuario = usuario;
        this.clave = clave;
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                JavaScriptClick.on(HomeUI.BTN_USER),
                Enter.theValue(usuario).into(HomeUI.TXT_USUARIO),
                Enter.theValue(clave).into(HomeUI.TXT_PASS),
                JavaScriptClick.on(HomeUI.BTN_INICIARSESION),
                GuardarLabel.on(HomeUI.LBL_USERNAME.resolveFor(actor))

        );




    }

    public static IniciarSesion conLasCredenciales(String usuario,String clave){
        return Instrumented.instanceOf(IniciarSesion.class).withProperties(usuario,clave);
    }
}
