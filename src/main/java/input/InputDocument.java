package input;

import com.codeborne.selenide.SelenideElement;
import pages.BasicPage;
import users.Users;

import java.util.Random;

import static browser.Browsers.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static users.Users.*;

public class InputDocument {

    private BasicPage page = new BasicPage();
    private SelenideElement layout_icon = $(".layout-icon");
    private SelenideElement field = $("html body.el-popup-parent--hidden div.el-dialog__wrapper div.el-dialog.user-list-dialogue-wrapper div.el-dialog__body div.user-select-dialogue-container div.user-selected-user-list-container div.tabs-wrapper div.column-container.tab-content-wrapper div.user-select-dialogue-wrapper div.table-container div.list-table.bg-color-white div.flex.flex-column.full-flex-sizes.p-r-16.table-header-container div.flex.ai-center.m-b-8 div.m-r-8.w-100.flex div.filter-container div.flex.full-with.filter-field.p-b-0 input#fio.base-input.full-with.fs-12");
    private final String BUTTON = "Выбрать";
    private final String PATH = "html body.el-popup-parent--hidden div.el-dialog__wrapper div.el-dialog.user-list-dialogue-wrapper div.el-dialog__footer span.dialog-footer button.primary.default-margin-right.btn-def.fs-12";
    private SelenideElement crsp_reg_number = $(byXpath("//*[@id=\"dss_crsp_reg_number\"]"));
    private SelenideElement fio = $("#fio");
    private SelenideElement reg_date = $(byXpath("//*[@id=\"dsdt_crsp_reg_date\"]"));
    private SelenideElement drid_addressee_empl = $("#drid_addressee_empl");
    private SelenideElement main_performer_empl = $("#dsid_main_performer_empl");

    public void correspondent(String key, String corentURL) {
        if (corentURL.equals(gettNt())) {
            page.searchFields("correspondent", AUTOTEST_NAME3);
            sleep(1000);
            if ($(byText(Users.AUTOTEST3AT)).is(visible)) {
                $(byText(Users.AUTOTEST3AT)).click();
            } else $(byText(Users.AUTOTEST3_TNT)).click();
        } else if (corentURL.equals(getKuban())) {
            page.searchFields("correspondent", AUTOTEST_NAME1);
            sleep(1000);
            if ($(byText(Users.AUTOTEST1KubanEnergo)).is(visible)) {
                $(byText(Users.AUTOTEST1KubanEnergo)).click();
            } else if ($(byText(Users.AUTOTEST1AT)).is(visible)) {
                $(byText(Users.AUTOTEST1AT)).click();
            }
        }

        /// сделать тоже самое для всех площадок такой же ифчик
        else {
            layout_icon.click();
            if (fio.is(visible)) {
                fio.setValue(AUTOTEST_NAME3);
            } else {
                field.setValue(AUTOTEST_NAME3);
            }
            sleep(1000);
            if ($(byText(Users.emploer_3)).is(visible)) {
                $$(byText(Users.emploer_3)).first().click();
            } else if ($(byText(Users.emploer3)).is(visible)) {
                $(byText((Users.emploer3))).click();
            } else if ($(byText(Users.AUTOTEST3_A_T)).is(visible)) {
                $(byText(Users.AUTOTEST3_A_T)).click();
            }

            $$(PATH).findBy(text(BUTTON)).click();
        }

    }

    public void srtRegNumberAndDay() {
        Random rd = new Random();
        crsp_reg_number.setValue(String.valueOf(rd.nextInt(301) + 10));
        crsp_reg_number.click();

        reg_date.click();
        sleep(1000);
        $$(byText("15")).last().click();

    }

    public void checkForDuplicates(String text, String proceed) {
        if ($(text).is(visible)) {
            $(byText(proceed)).click();
        }
    }

    public void addressee(String corentUrl,String name) {
            page.searchFields("addressee empl",name);
        if (corentUrl.equals(gettNt())) {
            $(byText(AUTOTEST1_TNT_EMPLOER)).click();
        } else if (corentUrl.equals(getMoeskSt())) {
           $(byText(Users.AUTOTEST_TESTE_DEP)).click();
        } else if (corentUrl.equals(getKuban())) {
            $(byText( Users.AUTOTEST_TESTE_DEP)).click();
        } else {
           $(byText( AUTOTEST1)).click();
        }

    }


}
