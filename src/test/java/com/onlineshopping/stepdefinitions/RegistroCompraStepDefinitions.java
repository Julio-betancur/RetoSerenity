package com.onlineshopping.stepdefinitions;

import com.onlineshopping.driver.SeleniumWebDriver;
import com.onlineshopping.globalvar.GlobarVars;
import com.onlineshopping.models.Usuario;
import com.onlineshopping.tasks.BuscarProducto;
import com.onlineshopping.tasks.ComprarProducto;
import com.onlineshopping.tasks.IniciarSesion;
import com.onlineshopping.tasks.Registrarse;
import com.onlineshopping.userinterface.LaptopUI;
import com.onlineshopping.userinterface.OrdenPagoUI;
import cucumber.api.java.Before;
import cucumber.api.java.en.*;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.hamcrest.Matchers;
import org.junit.Assert;

import java.util.List;

public class RegistroCompraStepDefinitions {

    //Instanciar al actor
    @Before
    public void before(){
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("^that Maria is in the homepage of advantageOnlineShopping (.*)$")
    public void thatMariaIsInTheHomepageOfAdvantageOnlineShoppingHttpsWwwAdvantageonlineshoppingCom(String url) {
        OnStage.theActorCalled("Maria").can(BrowseTheWeb.with(SeleniumWebDriver.ChromeDriver().on(url)));
    }


    @When("^she enters her credentials$")
    public void sheEntersHerCredentials(List<Usuario> listaUsuario) {
        OnStage.theActorInTheSpotlight().attemptsTo(Registrarse.conLasCredenciales(listaUsuario.get(0).getUsuario(),listaUsuario.get(0).getCorreo(),
                listaUsuario.get(0).getClave(), listaUsuario.get(0).getConfirmClave(),listaUsuario.get(0).getNombre(),listaUsuario.get(0).getApellido(),
                listaUsuario.get(0).getCelular(),listaUsuario.get(0).getPais(),listaUsuario.get(0).getCiudad(),listaUsuario.get(0).getDireccion(),
                listaUsuario.get(0).getDepartamento(),listaUsuario.get(0).getCodigoPostal()));
    }

    @Then("^she can validate that her (.*) was succesfully registered$")
    public void sheCanValidateThatHerTestingAWasSuccesfullyRegistered(String userName) {
        Assert.assertThat(GlobarVars.randomModel, Matchers.is(userName));
    }


    @When("^she logs in and buys a computer$")
    public void sheLogsInAndBuysAComputer(List<Usuario> listaUsuario) {
        OnStage.theActorInTheSpotlight().attemptsTo(IniciarSesion.conLasCredenciales(listaUsuario.get(0).getUsuario(),listaUsuario.get(0).getClave()));
        Assert.assertThat(GlobarVars.randomModel, Matchers.is(listaUsuario.get(0).getUsuario()));
        OnStage.theActorInTheSpotlight().attemptsTo(BuscarProducto.on());
        Assert.assertEquals(GlobarVars.randomModel.toUpperCase(),LaptopUI.LBL_NOMBRE_LAPTOP.resolveFor(OnStage.theActorInTheSpotlight()).getText());
        OnStage.theActorInTheSpotlight().attemptsTo(ComprarProducto.on());
    }

    @Then("^she can validate that the chosen computer corresponds to that of the payment order$")
    public void sheCanValidateThatTheChosenComputerCorrespondsToThatOfThePaymentOrder() {
        Assert.assertEquals(GlobarVars.randomModel.toUpperCase(), OrdenPagoUI.LBL_NOMBRE_LAPTOP.resolveFor(OnStage.theActorInTheSpotlight()).getText());
    }
}
