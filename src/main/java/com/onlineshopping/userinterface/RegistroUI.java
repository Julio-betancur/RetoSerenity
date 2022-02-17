package com.onlineshopping.userinterface;

import net.serenitybdd.screenplay.targets.Target;

public class RegistroUI {

    //Account Details
    public static final Target TXT_USERNAME = Target.the("Campo para colocar username").locatedBy("//input[@name='usernameRegisterPage']");
    public static final Target TXT_EMAIL = Target.the("Campo para colocar el email").locatedBy("//input[@name='emailRegisterPage']");
    public static final Target TXT_PASSWORD = Target.the("Campo para colocar clave").locatedBy("//input[@name='passwordRegisterPage']");
    public static final Target TXT_CONFIRMPASS = Target.the("Campo para confirmar clave").locatedBy("//input[@name='confirm_passwordRegisterPage']");

    //Personal Details
    public static final Target TXT_NOMBRE= Target.the("Campo para colocar nombre").locatedBy("//input[@name='first_nameRegisterPage']");
    public static final Target TXT_APELLIDO = Target.the("Campo para colocar apellido").locatedBy("//input[@name='last_nameRegisterPage']");
    public static final Target TXT_CELULAR = Target.the("Campo para colocar celular").locatedBy("//input[@name='phone_numberRegisterPage']");

    //Address
    public static final Target SELECT_PAIS = Target.the("Campo para seleccionar el pais").locatedBy("//select[@name='countryListboxRegisterPage']");
    public static final Target TXT_CIUDAD= Target.the("Campo para colocar la ciudad").locatedBy("//input[@name='cityRegisterPage']");
    public static final Target TXT_DIRECCION = Target.the("Campo para colocar la direccion").locatedBy("//input[@name='addressRegisterPage']");
    public static final Target TXT_DEPARTAMENTO = Target.the("Campo para colocar el departamento").locatedBy("//input[@name='state_/_province_/_regionRegisterPage']");
    public static final Target TXT_CODIGOPOSTAL = Target.the("Campo para colocar el codigo postal").locatedBy("//input[@name='postal_codeRegisterPage']");

    //Confirm registration
    public static final Target CHECK_ACEPTAR = Target.the("Campo para aceptar terminos y condiciones").locatedBy("//input[@name='i_agree']");
    public static final Target BTN_REGISTRARSE = Target.the("Boton para hacer registro").locatedBy("//button[@id='register_btnundefined']");
}
