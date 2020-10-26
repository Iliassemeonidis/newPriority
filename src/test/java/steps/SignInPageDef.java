package steps;

import config.UserConfig;
import io.cucumber.java.en.Then;
import pages.SignInPage;

public class SignInPageDef {

    private SignInPage signInPage = new SignInPage();

    @Then("Input login")
    public void inputLogin() {
        signInPage.inputLogin(UserConfig.AUTOTEST1);
    }

    @Then("Input password")
    public void inputPassword() {
        signInPage.inputPass(UserConfig.USER_PASS);
    }
}
