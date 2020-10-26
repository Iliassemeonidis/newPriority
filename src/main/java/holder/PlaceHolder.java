package holder;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public interface PlaceHolder {
    default void placeHolder(String holder,String text) {
        $(byXpath("//input[@placeholder='"+holder+"']")).setValue(text);
    }

}
