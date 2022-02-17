package com.onlineshopping.tasks;

import com.onlineshopping.interactions.GuardarLabel;
import com.onlineshopping.userinterface.HomeUI;
import com.onlineshopping.userinterface.RegistroUI;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.serenitybdd.screenplay.waits.Wait;

public class Registrarse implements Task {

    private String usuario;
    private String correo;
    private String clave;
    private String confirmClave;
    private String nombre;
    private String apellido;
    private String celular;
    private String pais;
    private String ciudad;
    private String direccion;
    private String departamento;
    private String codigoPostal;

    public Registrarse(String usuario, String correo, String clave, String confirmClave, String nombre, String apellido, String celular, String pais, String ciudad, String direccion, String departamento, String codigoPostal) {
        this.usuario = usuario;
        this.correo = correo;
        this.clave = clave;
        this.confirmClave = confirmClave;
        this.nombre = nombre;
        this.apellido = apellido;
        this.celular = celular;
        this.pais = pais;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.departamento = departamento;
        this.codigoPostal = codigoPostal;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {


        actor.attemptsTo(
                JavaScriptClick.on(HomeUI.BTN_USER),
                JavaScriptClick.on(HomeUI.BTN_CREARCUENTA),

                Enter.theValue(usuario).into(RegistroUI.TXT_USERNAME),
                Enter.theValue(correo).into(RegistroUI.TXT_EMAIL),
                Enter.theValue(clave).into(RegistroUI.TXT_PASSWORD),
                Enter.theValue(confirmClave).into(RegistroUI.TXT_CONFIRMPASS),

                Enter.theValue(nombre).into(RegistroUI.TXT_NOMBRE),
                Enter.theValue(apellido).into(RegistroUI.TXT_APELLIDO),
                Enter.theValue(celular).into(RegistroUI.TXT_CELULAR),

                Wait.until(WebElementQuestion.the(RegistroUI.SELECT_PAIS), WebElementStateMatchers.containsSelectOption(pais)).forNoLongerThan(10).seconds(),
                SelectFromOptions.byVisibleText(pais).from(RegistroUI.SELECT_PAIS),

                Enter.theValue(ciudad).into(RegistroUI.TXT_CIUDAD),
                Enter.theValue(direccion).into(RegistroUI.TXT_DIRECCION),
                Enter.theValue(departamento).into(RegistroUI.TXT_DEPARTAMENTO),
                Enter.theValue(codigoPostal).into(RegistroUI.TXT_CODIGOPOSTAL),
                Click.on(RegistroUI.CHECK_ACEPTAR),
                Click.on(RegistroUI.BTN_REGISTRARSE),

                Wait.until(WebElementQuestion.the(HomeUI.LBL_USERNAME),WebElementStateMatchers.isEnabled()).forNoLongerThan(10).seconds(),
                GuardarLabel.on(HomeUI.LBL_USERNAME.resolveFor(actor))
        );



    }

    public static Registrarse conLasCredenciales(String usuario, String correo, String clave, String confirmClave, String nombre, String apellido, String celular, String pais, String ciudad, String direccion, String departamento, String codigoPostal) {

        return Instrumented.instanceOf(Registrarse.class).withProperties(usuario, correo, clave, confirmClave, nombre, apellido, celular, pais, ciudad, direccion, departamento, codigoPostal);

    }
}
