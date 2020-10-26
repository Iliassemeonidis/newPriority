package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class SignInPage {

    private SelenideElement login = $(By.xpath("//input[@placeholder='Логин']"));
    private SelenideElement pass = $(By.xpath("//input[@placeholder='Пароль']"));


    public void inputLogin(String login) {
        this.login.setValue(login);
    }
    public void inputPass(String pass) {
        this.pass.setValue(pass);
    }
}
