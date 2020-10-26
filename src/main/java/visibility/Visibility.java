package visibility;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class Visibility {


    private boolean optical(String text) {
        return $(byText(text)).is(Condition.visible);
    }


    public void visibility(String text) {
        if (!optical(text)) $(byText(text)).scrollIntoView(true);
    }

    public boolean opticalCss(SelenideElement text) {
        return $(text).is(Condition.visible);
    }

    public boolean opticalXPath(String text) {
        return $(byXpath(text)).is(Condition.visible);
    }

    public void visibilityCss(SelenideElement text) {
        if (!opticalCss(text)) $(text).scrollIntoView(true);
    }

    public void visibilityXPath(String text) {
        if (!opticalXPath(text)) $(byXpath(text)).scrollIntoView(true);
    }

}