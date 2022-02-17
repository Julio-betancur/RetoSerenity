package com.onlineshopping.userinterface;

import net.serenitybdd.screenplay.targets.Target;

public class LaptopUI {

    public static final Target LBL_NOMBRE_LAPTOP = Target.the("Label para validar computador elegido").locatedBy("//h1[@class='roboto-regular screen768 ng-binding']");
    public static final Target BTN_GUARDAR_LAPTOP = Target.the("Boton para guardar la laptop en el carrito").locatedBy("//button[@name='save_to_cart']");
    public static final Target BTN_IR_PAGAR = Target.the("Boton para ir a pagar").locatedBy("//button[@id='checkOutPopUp']");



}
