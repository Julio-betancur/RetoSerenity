package com.onlineshopping.stepdefinitions;

import com.onlineshopping.abilities.ReadPdf;
import com.onlineshopping.driver.SeleniumWebDriver;
import cucumber.api.java.Before;
import cucumber.api.java.en.*;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.util.EnvironmentVariables;

import java.io.IOException;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class DownloadStepDefinitions {

    //Instanciar al actor
    @Before
    public void before(){
        OnStage.setTheStage(new OnlineCast());
    }

    String name;

    //Serenity properties - Serenity will instantiate this field automatically
    private EnvironmentVariables environmentVariables;

    String downloadFolder;
    String fileName;

    @Given("(.*) has made purchases with his credit card")
    public void pepito_has_made_purchases_with_his_credit_card(String name) throws InterruptedException {
        this.name = name;

        downloadFolder = environmentVariables.optionalProperty("download.filesFolder")
                .orElseThrow(IllegalArgumentException::new);

        fileName = environmentVariables.optionalProperty("statements.fileName")
                .orElseThrow(IllegalArgumentException::new);
    }

    @Given("she already downloaded her statements")
    public void he_already_downloaded_his_statements() throws InterruptedException {

        OnStage.theActorCalled("Maria").can(BrowseTheWeb.with(SeleniumWebDriver.ChromeDriver().on("https://file-examples-com.github.io/uploads/2017/10/file-sample_150kB.pdf")));

        Thread.sleep(5000);
    }

    @When("she reviews her transactions")
    public void he_reviews_his_transactions() throws IOException {

        String statementFilePath = String.format("%s/%s", downloadFolder, fileName);

        theActorInTheSpotlight().whoCan(ReadPdf.downloadedInPath(statementFilePath));

        String pdfText = ReadPdf.as(theActorInTheSpotlight()).getText();

        System.out.println(pdfText);
    }

    @Then("she should see the transactions for last month")
    public void he_should_see_the_transactions_for_last_month() {
    }
}
