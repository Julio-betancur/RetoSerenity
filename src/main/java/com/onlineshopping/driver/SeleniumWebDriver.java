package com.onlineshopping.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;

public class SeleniumWebDriver {
    public static WebDriver driver;

    public static SeleniumWebDriver ChromeDriver(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--star-maximized");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--incognito");


        //Setear para que chrome descargue automaticamente los archivos
        HashMap<String,Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("plugins.always_open_pdf_externally", true);
        options.setExperimentalOption("prefs",chromePrefs);


        driver = new ChromeDriver(options);
        return new SeleniumWebDriver();
    }

    public static WebDriver on(String url){
        driver.get(url);
        driver.manage().window().maximize();
        return driver;
    }
}
