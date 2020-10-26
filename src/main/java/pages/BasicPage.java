package pages;

import browser.Browsers;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import document.Finder;
import document.Resolution;
import holder.PlaceHolder;
import users.Users;
import visibility.Visibility;

import javax.swing.text.AbstractDocument;
import java.io.File;
import java.util.HashMap;
import java.util.Objects;

import static browser.Browsers.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static users.Users.*;


public class BasicPage implements PlaceHolder {

    private SelenideElement description = $("#dss_description");
    private SelenideElement vulture = $("#dsid_stamp");
    private SelenideElement thematic = $("#dsid_themes");
    private SelenideElement singer = $("#dsid_signer_empl");
    private SelenideElement external_addressee = $("#dsid_agent_person");
    private SelenideElement document_kind = $("#dsid_document_kind");
    private SelenideElement drid_addressee_empl = $("#drid_addressee_empl");
    private SelenideElement fio = $("#fio");
    private SelenideElement container = $(".items-container");
    private SelenideElement contentType = $("#dsid_content_type");
    private SelenideElement correspondent =  $("#dsid_agent_person");
    private SelenideElement delivery = $("#dsid_delivery");
    private SelenideElement control_date =  $("#dsdt_control_date");

    private SelenideElement search = $(byXpath("//input[contains(@placeholder,'Поиск')]"));
    private SelenideElement reg_number = $(byXpath("//*[@id=\"dss_reg_number\"]"));
    private SelenideElement downloadContent = $(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div/div[2]/div[2]/div/div[1]/div[1]/div/div/button[1]"));
    private SelenideElement reportText = $(byXpath("//*[@id=\"reportText\"]"));
    private SelenideElement textarea = $(".container__executors_textarea");
    private SelenideElement main_performer_empl = $("#dsid_main_performer_empl");


    private String registrationNumber = null;
    private String russianTranslRegNumb = "Регистрационный номер";
    private String USER_NAME4 = "Автотест4 , Сотрудник, Тестовый отдел";
    private String save = "Сохранить";

    private SelenideElement scanForm = $(byText("Сканированный образ"));
    private Visibility visibility = new Visibility();
    private Finder finder = new Finder();
    private Resolution resolution = new Resolution();

    private SelenideElement button = $("body > div.column-container > div.column-container > div > div.column-container.layout-content-container > div.column-container > div.tabs-wrapper.content-block.overflow-hidden > div.column-container.tab-content-wrapper > div > div.column-container.pos-relative > div.tabs-wrapper > div.column-container.tab-content-wrapper > div > div.fields-wrapper > div:nth-child(11) > div > div > div.user-list-container > div > div > div.input-select-container.fs-12.full-with.user-compendium-select.w-100 > div > div > div.text-select-icons-container > button");
    private final String BUTTON = "Выбрать";
    private final String PATH = "html body.el-popup-parent--hidden div.el-dialog__wrapper div.el-dialog.user-list-dialogue-wrapper div.el-dialog__footer span.dialog-footer button.primary.default-margin-right.btn-def.fs-12";
    private String message = "Письмо";
    private String outgoingMessages = "Исходящие письма внешним адресатам";
    private String branchLetters = "Письма филиалов";
    private SelenideElement buttonMoreContent = $("button.rounded-button:nth-child(4)");
    private HashMap<String, SelenideElement> fields = new HashMap<>();


    public void searchFields(String field, String text) {
        fields.put("Подписант", singer);
        fields.put("description", description);
        fields.put("Штамп", vulture);
        fields.put("thematic", thematic);
        fields.put("document kind", document_kind);
        fields.put("external addressee", external_addressee);
        fields.put("addressee empl", drid_addressee_empl);
        fields.put("correspondent", correspondent);
        fields.put("delivery", delivery);
        fields.put("control date", control_date);
        fields.put("performer empl", main_performer_empl);


        SelenideElement element = fields.get(field);
        visibility.visibilityCss(element);
        if (element.is(empty)) {
            element.setValue(text);
        }
    }

    public void clickOnButton(String text) {
        visibility.visibility(text);
        $(byText(text)).click();
    }

    public void clickOnLastButton(String text) {
        $$(byText(text)).get($$(byText(text)).size() - 1).click();
    }

    public void findAndClickOnDocumentInContainer(String text) {
        visibility.visibility(text);
        container.find(byText(text)).click();
    }

    public void createDocumentIsVisible(String text) {
        if (!$(byText(text)).is(Condition.visible)) {
            Users.exit();
            Users.comInAutotest1();
        }
    }


    public void contentUpload(String fileName) {
        System.out.println($$("input").size());
        $$("input").first().uploadFile(new File(fileName));
    }

    public void contentUploadLast(String fileName) {
        $$("input").last().uploadFile(new File(fileName));
    }

    public void setValueInReportText(String text) {
        if (reportText.is(visible)) {
            reportText.setValue(text);
        } else {
            textarea.setValue(text);
        }
    }

    public static void contentUploadForAnswer(String fileName) {
        ElementsCollection elements = $$("input");
        if (elements.size() > 3) {
            elements.get(2).uploadFile(new File(fileName));
        } else {
            elements.get(1).uploadFile(new File(fileName));
        }

    }

    public void downloadContent() {
        sleep(1000);
        downloadContent.click();
        sleep(1000);
    }

    public String setDescription(String description, String text) {
        searchFields(description, text);
        return this.description.getValue();
    }

    public void vulture(String corentURL,String key, String text) {
        if (!corentURL.equals(getSedoIdMtRu())) {
            searchFields(key,text);
            $(byText(text)).click();

        }
    }

    public void setThematic(String corentUrl, String text) {
        if (corentUrl.equals(getKuban())) {
            searchFields("thematic", text);
            $(byText(text)).click();
        }


    }

    public void setSinger(String name, String corentUrl) {

        visibility.visibilityCss(singer);
        singer.setValue(name);
        if (corentUrl.equals(getKuban())) {
            $(byText(Users.AUTOTEST_KUB2)).click();
        } else if (corentUrl.equals(gettNt())) {
            $(byText(Users.AUTOTEST2_TNT_EMPLOER)).click();
        } else {
            $(byText(Users.AUTOTEST2)).click();
        }

    }

    public void employeeSearch(String name) {
        search.setValue(name);
    }

    public String getValue(String text) {
        if (text.equals(russianTranslRegNumb)) {
            return registrationNumber = reg_number.getValue();
        }
        return null;

    }

    public void changeUser(String text) {
        switch (text) {
            case Users.AUTOTEST_NAME1:
                Users.exit();
                Users.comInAutotest1();
                break;
            case Users.AUTOTEST_NAME2:
                Users.exit();
                Users.comInAutotest2();
                break;
            case AUTOTEST_NAME3:
                Users.exit();
                Users.comInAutotest3();
                break;
            case AUTOTEST_NAME4:
                Users.exit();
                Users.comInAutotest4();
                break;
            case Users.AUTOTEST_NAME5:
                Users.exit();
                Users.comInAutotest5();
                break;
        }
    }

    public void tryToFindDocumentUseTheDocumentSRegistrationNumber(String text) {
        finder.tryToFindDocWithDescription(text);
    }


    public void completeTheResolution(String text) {
        resolution.create(text);
    }

    public void shouldNotBe(String text) {
        sleep(100);
        $(byText(text)).shouldNotBe(Condition.visible);
    }

    public void completeTheDocumentKind(String documentKind) {
        searchFields(documentKind, "Письм");
        sleep(10000);
        if ($(byText(message)).is(visible)) {
            $(byText(message)).click();
        } else if ($(byText(outgoingMessages)).is(visible)) {
            $(byText(outgoingMessages)).click();
        } else if ($(byText(branchLetters)).is(visible)) {
            $(byText(branchLetters)).click();
        }
//        if (Objects.requireNonNull(document_kind.getValue()).isEmpty()) {
//
//
//            document_kind.setValue("Письм");
//            sleep(10000);
//            if ($(byText(message)).is(visible)) {
//                $(byText(message)).click();
//            } else if ($(byText(outgoingMessages)).is(visible)) {
//                $(byText(outgoingMessages)).click();
//            } else if ($(byText(branchLetters)).is(visible)) {
//                $(byText(branchLetters)).click();
//            }
//        }
    }

    public void addresseeEmpl(String corentUrl, String key, String name) {
        // ВНЕШНИЙ АДРЕСАТ
        if (!corentUrl.equals(getLeSt())) {
            searchFields(key, name);
            if (corentUrl.equals(Browsers.getKuban())) {
                $(byText(USER_NAME4)).click();
            } else if (corentUrl.equals(Browsers.gettNt())) {
                $(byText(AUTOTEST4_TNT_EMPLOER)).click();
            } else if (corentUrl.equals(Browsers.getSedoIdMtRu())) {
                button.click();
                fio.setValue(AUTOTEST_NAME3);
                $(byText("Москва")).click();
                $$(PATH).findBy(text(BUTTON)).click();
            }
            sleep(10000);
        }

    }

    public void agentPerson(String key, String name) {

        SelenideElement button1 = $("div.form-item-container:nth-child(14) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > button:nth-child(1)");
        SelenideElement button2 = $("div.form-item-container:nth-child(16) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > button:nth-child(1)");
        // Внешний аресат
        searchFields("external addressee", name);
        if ($(byText(Users.AUTOTEST3LenEnergo)).is(visible)) {
            $$(byText(Users.AUTOTEST3LenEnergo)).first().click();
        } else if ($(byText(Users.AUTOTEST3_AiDi)).is(visible)) {
            $(byText(Users.AUTOTEST3_AiDi)).click();
        } else if ($(byText(Users.AUTOTEST3_TNT)).is(visible)) {
            $(byText(Users.AUTOTEST3_TNT)).click();
        } else if ($(byText(Users.AUTOTEST3AT)).is(visible)) {
            $(byText(Users.AUTOTEST3AT)).click();
        } else if (button1.is(visible)) {
            button1.click();
            fio.setValue(AUTOTEST_NAME3);
            sleep(1000);
            $(byText(Users.emploer3)).click();
            $$(PATH).findBy(text(BUTTON)).click();
        } else if (button2.is(visible)) {
            button2.click();
            fio.setValue(AUTOTEST_NAME1);
            sleep(1000);
            $(byText(Users.emploer1)).click();
            $$(PATH).findBy(text(BUTTON)).click();
        } else if (name.equals(AUTOTEST_NAME1)) {
            if ($(byText(Users.AUTOTEST1KubanEnergo)).is(visible)) {
                $(byText(Users.AUTOTEST1KubanEnergo)).click();
            }
            else if ($(byText(Users.AUTOTEST1AT)).is(visible)) {
                $(byText(Users.AUTOTEST1AT)).click();
            }
        }
    }

    ///TODO Переписать этот хардкод метод !!!!!!!!!
    public void addresseType(String corentUrl) {
        if (corentUrl.equals(Browsers.getLeTest()) || (corentUrl.equals(Browsers.getKuban())) || corentUrl.equals(Browsers.gettNt()) || corentUrl.equals(Browsers.getMoeskSt())) {
            if (!corentUrl.equals(Browsers.getKuban()) && !corentUrl.equals(Browsers.getMoeskSt())) {

                $("#dsid_addresse_type").scrollIntoView(true);
                String type = $("#dsid_addresse_type").getValue();
                if (!type.equals("Внутренний адресат")) {
                    agentPerson("#dsid_addresse_type",AUTOTEST_NAME3);
                }
            } else if (corentUrl.equals(Browsers.gettNt())) {
                agentPerson("#dsid_addresse_type",AUTOTEST_NAME3);
            } else if (corentUrl.equals(Browsers.getMoeskSt())) {
                $("#dsid_delivery").setValue("Курьер");
                sleep(1000);
                $(byText("Курьер")).click();
            } else {
                agentPerson("#dsid_addresse_type",AUTOTEST_NAME1);
                $("#dsid_delivery").setValue("Курьер");
                sleep(1000);
                $(byText("Курьер")).click();
            }
        }

    }

    public void uploadMoreContent() {
        buttonMoreContent.click();
        contentUploadLast("test.txt");
        contentType.click();
        sleep(1000);
        scanForm.click();
        $$(byText(save)).last().click();
    }





}


