package com.onlineshopping.builders;

import com.onlineshopping.interactions.GuardarLabel;
import com.onlineshopping.userinterface.HomeUI;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.serenitybdd.screenplay.waits.Wait;

public class Login implements Task {
    //Se crean las variables a utilizar para loguearse
    private String username;
    private String password;
    private boolean rememberMe;

    //Constructor para inicializar las variables
    public Login(String username, String password, boolean rememberMe) {
        this.username = username;
        this.password = password;
        this.rememberMe = rememberMe;
    }

    //Metodo estatico que retorna clase LoginWith (clase builder)
    public static LoginWith with() {
        return new LoginWith();
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                JavaScriptClick.on(HomeUI.BTN_USER),
                Enter.theValue(username).into(HomeUI.TXT_USUARIO),
                Enter.theValue(password).into(HomeUI.TXT_PASS)
        );

        if (rememberMe) {
            actor.attemptsTo(
                    JavaScriptClick.on(HomeUI.CHECK_REMEMBER)
            );
        }

        actor.attemptsTo(
                JavaScriptClick.on(HomeUI.BTN_INICIARSESION),
                Wait.until(WebElementQuestion.the(HomeUI.LBL_USERNAME), WebElementStateMatchers.isVisible()).forNoLongerThan(10).seconds(),
                GuardarLabel.on(HomeUI.LBL_USERNAME.resolveFor(actor))
        );
    }

    //Cuando se llama esta clase se crean las variables y metodos que se utilizan para pasar los valores a las variables
    public static class LoginWith {
        private String username;
        private String password;

        //Inicializamos la variable con un valor y devolvemos esta misma clase
        public LoginWith username(String username) {
            this.username = username;
            return this;
        }

        //Inicializamos la variable con un valor y devolvemos esta misma clase
        public LoginWith andPassword(String password) {
            this.password = password;
            return this;
        }

        //Metodo perfomable para llamar constructor de login pasandole los valores
        public Performable rememberMe(boolean rememberMe) {
            return new Login(username, password, rememberMe);
        }

    }
}
