package com.onlineshopping.userinterface;

import net.serenitybdd.screenplay.targets.Target;

public class HomeUI {
    public static final Target BTN_USER = Target.the("Boton para entrar a la cuenta").locatedBy("//a[@id='menuUserLink']");
    public static final Target BTN_CREARCUENTA = Target.the("Boton para crear cuenta").locatedBy("//a[@class='create-new-account ng-scope']");

    public static final Target LBL_USERNAME = Target.the("Label para validar el registro exitoso").locatedBy("//span[@class='hi-user containMiniTitle ng-binding']");

    public static final Target TXT_USUARIO = Target.the("Campo para ingresar el usuario").locatedBy("//input[@name='username']");
    public static final Target TXT_PASS = Target.the("Campo para ingresar la clave").locatedBy("//input[@name='password']");
    public static final Target BTN_INICIARSESION = Target.the("Boton para Iniciar sesion").locatedBy("//button[@id='sign_in_btnundefined']");

    public static final Target CHECK_REMEMBER = Target.the("Check para recordar credenciales").locatedBy("//input[@name='remember_me']");

    public static final Target BTN_LAPTOS = Target.the("Boton para ir a la seccion de laptos").locatedBy("//div[@id='laptopsImg']");

}
