package com.onlineshopping.runners;


import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/RegistroCompra.feature",
        glue = "com.onlineshopping.stepdefinitions",
        snippets = SnippetType.CAMELCASE
)
public class RegistroCompraRunner {
}
