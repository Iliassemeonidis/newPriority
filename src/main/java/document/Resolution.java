package document;

import browser.Browsers;
import com.codeborne.selenide.Browser;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.eo.Se;
import org.openqa.selenium.support.ui.Sleeper;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static users.Users.AUTOTEST5;
import static users.Users.AUTOTEST_NAME5;

public class Resolution {

    private SelenideElement performers = $(byXpath("//*[@id=\"performers\"]"));
    private SelenideElement button = $("div.pos-relative:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > button:nth-child(1)");
    private SelenideElement query = $("#query");
    private  String fastOneDay = "Незамедлительно: (+ 1 день)";
    private  String inWork = "В работу";
    private String userName5 = "Автотест5 , Сотрудник, Департамент 3";
    private final String BUTTON = "Выбрать";
    private final String PATH = "html body.el-popup-parent--hidden div.el-dialog__wrapper div.el-dialog.user-list-dialogue-wrapper div.el-dialog__footer span.dialog-footer button.primary.default-margin-right.btn-def.fs-12";
    private SelenideElement time = $(byXpath("//*[@id=\"Дата исполнения\"]"));
    private SelenideElement period = $("#period");
    private SelenideElement dssDescription = $(byXpath("//*[@id=\"dssDescription\"]"));
    private SelenideElement save=  $("div.el-dialog__footer:nth-child(3) > span:nth-child(1) > button:nth-child(2)");
    private SelenideElement dsidControllerEmpl = $("#dsidControllerEmpl");
    private SelenideElement but = $("div.input-field-container:nth-child(7) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > small:nth-child(1)");

    public void create(String corentUrl) {
        performers.setValue(AUTOTEST_NAME5);
        sleep(1000);
        if ($(byText(AUTOTEST5)).is(visible)) {
            $(byText(AUTOTEST5)).click();
        } else{
           button.click();
            sleep(1000);
            query.setValue(AUTOTEST_NAME5);
            if (!$(byText(AUTOTEST_NAME5)).is(visible)) {
                query.setValue(AUTOTEST_NAME5);
            }
            $(byText(AUTOTEST_NAME5)).click();
            $$(PATH).findBy(text(BUTTON)).click();
        }

        if (time.is(Condition.visible)) {
            time.click();
        } else {
            period.click();
        }

        $(byText(fastOneDay)).click();

        dssDescription.setValue(inWork);
        if (!corentUrl.equals(Browsers.gettNt())) {
            // контролер
            but.click();
            sleep(1000);
            dsidControllerEmpl.setValue(AUTOTEST_NAME5);
            sleep(1000);
            if (corentUrl.equals(Browsers.getVolsProd()) || corentUrl.equals(Browsers.getVolsSt())) {
                $(byText(userName5)).click();
            } else {
                $(byText(AUTOTEST5)).click();
            }
        }
        save.click();
        sleep(10000);
    }


}
