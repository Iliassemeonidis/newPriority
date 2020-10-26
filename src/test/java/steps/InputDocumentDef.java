package steps;

import browser.Browsers;
import com.codeborne.selenide.SelenideElement;
import input.InputDocument;
import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Then;
import pages.BasicPage;

import static browser.Browsers.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class InputDocumentDef {

    private InputDocument inputDocument = new InputDocument();
    private BasicPage page = new BasicPage();
    private static String corentUrl = Hooks.getCorentUrl();
    private static String status = "div.form-item-container:nth-child(2) > div:nth-child(1) > div:nth-child(2)";


    @Then("if url equals Kuban Energo, upload document And Click {string}")
    public void ifUrlEqualsKubanEnergoUploadDocumentAndClick(String arg0) {
        if (corentUrl.equals(Browsers.getKuban())) {
            String INPUT_DOC = "Входящий документ.docx";
            page.contentUpload(INPUT_DOC);
            $(byText(arg0)).click();
        }

    }

    @Then("add correspondent")
    public void addCorrespondent() {
        inputDocument.correspondent("correspondent", corentUrl);
    }

    @And("set reg_number and day of registration")
    public void setReg_numberAndDayOfRegistration() {
        inputDocument.srtRegNumberAndDay();
    }

    @Then("Upload input document {string}")
    public void uploadInputDocument(String arg0) {
        if (!corentUrl.equals(getKuban())) {
            page.contentUpload(arg0);
        }
    }

    @But("if {string} is visible click on {string}")
    public void ifIsVisibleClickOn(String arg0, String arg1) {
        inputDocument.checkForDuplicates(arg0, arg1);
    }

    @Then("write delivery {string}")
    public void writeDelivery(String arg0) {
        if (corentUrl.equals(getKuban()) || corentUrl.equals(getMoeskSt())) {
            page.searchFields("delivery", arg0);
            $(byText(arg0)).click();
        }

    }

    @And("write thematic {string}")
    public void writeThemes(String arg0) {
        if (corentUrl.equals(getKuban())) {
            page.searchFields("thematic", arg0);
            $(byText(arg0)).click();
        }
    }

    @Then("Write addressee empl inputDoc {string}")
    public void writeAddresseeEmplInputDoc(String arg0) {
        inputDocument.addressee(corentUrl, arg0);

    }

    @Then("Write document kind {string}")
    public void writeDocumentKind(String arg0) {

        page.searchFields("document kind", arg0);
        String internalCorrespondence = "Внутренняя переписка";
        String incomingDocuments = "Входящие документы";
        String message = "Письма федеральных органов власти";

        if ($(byText(internalCorrespondence)).is(visible)) {
            $(byText(internalCorrespondence)).click();
        } else if ($(byText(incomingDocuments)).is(visible)) {
            $(byText(incomingDocuments)).click();
        } else if ($(byText(message)).is(visible)) {
            $(byText(message)).click();
        }

    }

    @Then("Write control date")
    public void writeControlDate() {
        page.searchFields("control date","15");
        $$(byText("15")).last().click();
    }

    @Then("status in {string}")
    public void statusIn(String arg0) {
        $$(status).findBy(text(arg0));

    }

    @And("must not be visible {string}")
    public void mustNotBeVisible(String arg0) {
        $(byText(arg0)).shouldNotBe(visible);
    }
}
