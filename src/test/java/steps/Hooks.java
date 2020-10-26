package steps;

import browser.Browsers;
import io.cucumber.java.Before;


import static com.codeborne.selenide.Configuration.browser;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;

public class Hooks {
    private static String corentUrl;

   @Before
    public void openUrl() {
        browser = "firefox";
         String url = System.getProperty("siteurl");
        open(url);
       corentUrl = url();
    }

    public static String getCorentUrl() {
        return corentUrl;
    }
}
