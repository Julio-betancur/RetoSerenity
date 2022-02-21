package com.onlineshopping.runners;


import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/Download.feature",
        glue = "com.onlineshopping.stepdefinitions",
        tags = "@pdf",
        snippets = SnippetType.CAMELCASE
)
public class DownloadRunner {
}
