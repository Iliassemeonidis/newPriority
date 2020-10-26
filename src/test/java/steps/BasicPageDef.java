package steps;

import browser.Browsers;
import io.cucumber.java.en.Then;
import pages.BasicPage;

import static browser.Browsers.*;
import static com.codeborne.selenide.Configuration.browser;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.url;

public class BasicPageDef {

    private BasicPage basicPage = new BasicPage();
    private static String corentUrl = Hooks.getCorentUrl();
    private static String registrationNumber;
    private static String description;
    private final String ANSWER = "ответ.txt";
    private final String createDoc = "Создать документ";

    @Then("Click {string}")
    public void click(String arg0) {
        if (arg0.equals(createDoc)) {
            basicPage.createDocumentIsVisible(arg0);
        }
        basicPage.clickOnButton(arg0);
    }


    @Then("Open browser {string}")
    public void openBrowser(String arg0) {
        browser = "firefox";
        if (arg0.isEmpty()) return;
        if (arg0.equals(getNameLeTest())) {
            open(Browsers.getLeTest());
        } else if (arg0.equals(getLeSt())) {
            open(Browsers.getLeSt());
        } else if (arg0.equals(getNameLeProd())) {
            open(Browsers.getLeProd());
        } else if (arg0.equals(getNameKuban())) {
            open(Browsers.getKuban());
        } else if (arg0.equals(getNameVolsSt())) {
            open(Browsers.getVolsSt());
        } else if (arg0.equals(getNameVolsProd())) {
            open(Browsers.getVolsProd());
        } else if (arg0.equals(getNameTNt())) {
            open(Browsers.gettNt());
        } else if (arg0.equals(getNameRossSet())) {
            open(Browsers.getRossSet());
        } else if (arg0.equals(getNamSiberia())) {
            open(Browsers.getSiberia());
        }
        corentUrl = url();

    }

    @Then("Wait")
    public void waitToBeVisible() {
        sleep(1000);
    }


    @Then("Upload document {string}")
    public void uploadDocument(String arg0) {
        basicPage.contentUpload(arg0);
    }

    @Then("Write description {string}")
    public void writeDescription(String arg0) {
        description = basicPage.setDescription("description", arg0);
    }


    @Then("Write stamp {string}")
    public void writeStamp(String arg0) {
        basicPage.vulture(corentUrl, "stamp", arg0);
    }

    @Then("Write thematic {string}")
    public void writeThematic(String arg0) {
        basicPage.setThematic(corentUrl, arg0);
    }

    @Then("Singer {string}")
    public void singer(String arg0) {
        basicPage.setSinger(arg0, corentUrl);
    }


    @Then("Click on document {string}")
    public void clickOnDocument(String arg0) {
        if (corentUrl.equals(getSedoIdMtRu())) {

        }
        basicPage.findAndClickOnDocumentInContainer(arg0);
    }

    @Then("If write thematic is visible {string}")
    public void ifWriteThematicIsVisible(String arg0) {
    }

    @Then("Copy {string}")
    public void copyRegistrationNumber(String arg0) {
        registrationNumber = basicPage.getValue(arg0);
        System.out.println(registrationNumber);
    }

    @Then("Go to {string}")
    public void goToReviewer(String arg0) {
        basicPage.changeUser(arg0);
    }

    @Then("try to find document use the document's registration number")
    public void tryToFindDocumentUseTheDocumentSRegistrationNumber() {
        basicPage.tryToFindDocumentUseTheDocumentSRegistrationNumber(registrationNumber);
    }

    @Then("Download content")
    public void downloadContent() {
        basicPage.downloadContent();
    }

    @Then("Upload content for answer and write description {string}")
    public void uploadContentForAnswer(String arg0) {
        basicPage.contentUpload(ANSWER);
        basicPage.setValueInReportText(arg0);
    }

    @Then("Click on {string}")
    public void clickOn(String arg0) {
        basicPage.clickOnLastButton(arg0);
    }

    @Then("Complete the Resolution")
    public void completeTheResolution() {
        basicPage.completeTheResolution(corentUrl);
    }

    @Then("should not be visible {string}")
    public void shouldNotBeVisible(String arg0) {
        basicPage.shouldNotBe(arg0);
    }

    @Then("complete the document kind")
    public void completeTheDocumentKind() {
        basicPage.completeTheDocumentKind("document kind");
    }

    @Then("Write addressee empl output doc {string}")
    public void writeAddresseeEmpl(String arg0) {
        basicPage.addresseeEmpl(corentUrl, "addressee empl", arg0);
    }


    @Then("upload more content")
    public void uploadMoreContent() {
        basicPage.uploadMoreContent();
    }


}
