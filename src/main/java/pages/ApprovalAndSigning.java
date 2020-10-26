package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import holder.PlaceHolder;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class ApprovalAndSigning implements PlaceHolder {

    private SelenideElement completeCondition = $(byXpath("//input[@id='completeCondition']"));
    private SelenideElement layout_icon_click = $(".layout-icon");
    private SelenideElement query = $(byXpath("//*[@id=\"query\"]"));
    private String holder = "Пожалуйста, выберите участника";

    ///TODO изменить эту кнопку у проверяющего
    private SelenideElement add = $(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div/div[2]/div[2]/div/div[5]/div[3]/div[2]/div/div[1]/div[3]/button[1]"));


    private final String BUTTON = "Выбрать";
    private final String PATH = "html body.el-popup-parent--hidden div.el-dialog__wrapper div.el-dialog.user-list-dialogue-wrapper div.el-dialog__footer span.dialog-footer button.primary.default-margin-right.btn-def.fs-12";
    private String append = "Добавить";
    private String save = "Сохранить";
    private String addStage = "Добавить этап";
    private SelenideElement term = $(byXpath("//*[@id=\"term\"]"));
    private SelenideElement columnContainer =$(byXpath("//div[@class='column-container']//div[4]//div[2]//div[1]//div[1]//div[3]//button[1]//div[1]//*[local-name()='svg']"));
    private SelenideElement inputWrapper =  $(byXpath("//div[contains(@class,'input-wrapper')]//div[contains(@class,'user-list-container')]//div//div[@class='el-tooltip']//*[local-name()='svg']"));
    private SelenideElement approvers = $("#approvers");
    private int secondToSlip = 1000;
    private SelenideElement trim = $("#term");


    public void completeCondition(String text) {
        completeCondition.click();
        $(byText(text)).click();
    }

    public void addStageChecking() {
        if (add.isDisplayed()) {
            add.click();
        } else {
            $$(byText(addStage)).get(0).click();
        }
    }

    public void creteDesignReviewer(String userName) {
        if (trim.is(Condition.visible)) {
            trim.setValue("2");
        }
        layout_icon_click.click();
        setUserName(userName);
    }

    public void addAApprovalStageAndApprover(String userName) {
        if (!$(byText(addStage)).isDisplayed()) {
            $$(byText(addStage)).get(0).click();
        } else if ($$(byText(addStage)).size() > 1) {
           $$(byText(addStage)).last().click();
        } else {
            $(byText(addStage)).click();
        }

        if (term.is(Condition.visible)) term.setValue("3");

       creteDesignReviewer(userName);


    }

  public void addApprover(String userName) {

      if (columnContainer.is(Condition.visible)) {
         columnContainer.click();

          if (inputWrapper.is(visible)) {
              inputWrapper.click();
          }
      }

      setUserName(userName);
  }

    private void setUserName(String userName) {
        sleep(secondToSlip);
        query.setValue(userName);
        $(byText(userName)).click();
        $$(PATH).findBy(text(BUTTON)).click();
        if (!$(byText(append)).isDisplayed()) {
            $$(byText(save)).get($$(byText(save)).size()-1).click();
        } else $(byText(append)).click();
    }
}
