package document;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class Finder {

    private final static SelenideElement ALL_TASKS = ($(byText("Все задания")));
    private final static SelenideElement MY_TASKS = $(byText("Мои задания"));
    private SelenideElement button1 = $(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div[1]/div/div[1]/div[1]/div[1]/div/button"));
    private SelenideElement button2 = $(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div[1]/div/div[1]/div[1]/div[1]/div/div[4]/div[2]/button"));
    private SelenideElement base_input = $(".base-input");
    private SelenideElement desc = $("#desc");
    private SelenideElement input_search_button = $(".input-search-button");




    public void isVisibleAllTask() {
        if (!ALL_TASKS.is(visible)) {
            MY_TASKS.click();
        }
        ALL_TASKS.click();
        sleep(1000);
    }

    public void tryToFindDocWithDescription(String text) {
        isVisibleAllTask();
        if (button1.is(Condition.visible)) {
            button1.click();
        }
        if (base_input.is(Condition.visible)) {
            base_input.setValue(text);
        } else {
            desc.setValue(text);
        }

        if (input_search_button.is(Condition.visible)) {
            input_search_button.click();
        }
        sleep(10000);

        if (button2.is(Condition.visible)) {
            button2.click();
            sleep(1000);
        }

        if (desc.is(Condition.visible)) {
            desc.setValue(text);
            sleep(10000); }

        if ($(byText("Распорядительные документы")).is(Condition.visible)) {

            $$(byText("Распорядительные документы"))
                    .first()
                    .click();
        } else if ($(byText("ОРД")).is(Condition.visible)) {
            $$(byText("ОРД"))
                    .first()
                    .click();
        } else if ($(byText("Материалы")).is(Condition.visible)) {
            $$(byText("Материалы"))
                    .first()
                    .click();
        } else if ($(byText("Договоры (ВОЛС)")).is(Condition.visible)) {
            $$(byText("Договоры (ВОЛС)"))
                    .first()
                    .click();
        } else if ($(byText("Дополнительное соглашение (ВОЛС)")).is(Condition.visible)) {
            $$(byText("Дополнительное соглашение (ВОЛС)"))
                    .first()
                    .click();
        } else if ($(byText("Первичная документация")).is(Condition.visible)) {
            $$(byText("Первичная документация"))
                    .first()
                    .click();
        } else if ($(byText("Приказы о командировании")).is(Condition.visible)) {
            $$(byText("Приказы о командировании"))
                    .first()
                    .click();
        }else if ($(byText("Договор (КЭ)")).is(Condition.visible)) {
            $$(byText("Договор (КЭ)"))
                    .first()
                    .click();
        }else if ($(byText("Договоры")).is(Condition.visible)) {
            $$(byText("Договоры"))
                    .first()
                    .click();
        }else if ($(byText("Дополнительное соглашение (КЭ)")).is(Condition.visible)) {
            $$(byText("Дополнительное соглашение (КЭ)"))
                    .first()
                    .click();
        }else if ($(byText("Дополнительное соглашение")).is(Condition.visible)) {
            $$(byText("Дополнительное соглашение"))
                    .first()
                    .click();
        }else if ($(byText("Выписка из протоколов")).is(Condition.visible)) {
            $$(byText("Выписка из протоколов"))
                    .first()
                    .click();
        }else if ($(byText("Протокол")).is(Condition.visible)) {
            $$(byText("Протокол"))
                    .first()
                    .click();
        } else if ($(byText("Протоколы органов управления")).is(Condition.visible)) {
            $$(byText("Протоколы органов управления"))
                    .first()
                    .click();
        } else if ($(byText("Материалы органов управления")).is(Condition.visible)) {
            $$(byText("Материалы органов управления"))
                    .first()
                    .click();
        }else if ($(byText("Выписки из протоколов органов управления")).is(Condition.visible)) {
            $$(byText("Выписки из протоколов органов управления"))
                    .first()
                    .click();
        }else if ($(byText("Приказ")).is(Condition.visible)){
            $$(byText("Приказ"))
                    .first()
                    .click();
        }else if ($(byText("Исходящие документы")).is(Condition.visible)){
            $$(byText("Исходящие документы"))
                    .first()
                    .click();
        }

    }


//    public static void tryToFindDocWithSinger(String text) {
//        // ием по подписанту
//        if ($(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div[1]/div/div[1]/div[1]/div[1]/div/button")).is(Condition.visible)) {
//
//            $(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div[1]/div/div[1]/div[1]/div[1]/div/button")).click();
//        }
//        if ($(".base-input").is(Condition.visible)) {
//            $(".base-input").setValue(text);
//        } else {
//            $(byXpath("//*[@id=\"desc\"]")).setValue(text);
//        }
//        if ($(".input-search-button").is(Condition.visible)) {
//            $(".input-search-button").click();
//        }
//        sleep(10000);
//        if ($(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div[1]/div/div[1]/div[1]/div[1]/div/div[4]/div[2]/button")).is(Condition.visible)) {
//
//            $(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div[1]/div/div[1]/div[1]/div[1]/div/div[4]/div[2]/button")).click();
//            sleep(1000);
//        }
//        if ($(byText("Распорядительные документы")).is(Condition.visible)) {
//
//            $$(byText("Распорядительные документы"))
//                    .first()
//                    .click();
//        }else if ($(byText("Приказ")).is(Condition.visible)){
//            $$(byText("Приказ"))
//                    .first()
//                    .click();
//        } else {
//            $$(byText("ОРД"))
//                    .first()
//                    .click();
//        }
//        if ($("#desc").is(Condition.visible)) {
//            $("#desc").setValue(text);
//            sleep(10000);
//
//            if($(byText("Распорядительные документы")).is(Condition.visible)) {
//
//                $$(byText("Распорядительные документы"))
//                        .first()
//                        .click();
//            } else {
//                $$(byText("ОРД"))
//                        .first()
//                        .click();
//            }
//        }
//
//    }
//
//
//    public  void tryToFindDoc(String text) {
//        // ием по подписанту
//       isVisibleAllTask();
//
//        $(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div[1]/div/div[1]/div[1]/div[1]/div/button")).click();
//        if ($(".base-input").is(Condition.visible)) {
//            $(".base-input").setValue(text);
//        } else {
//
//            $(byXpath("//*[@id=\"desc\"]")).setValue(text);
//        }
//        if ($(".input-search-button").is(Condition.visible)) {
//            $(".input-search-button").click();
//        }
//        sleep(10000);
//        $(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div[1]/div/div[1]/div[1]/div[1]/div/div[4]/div[2]/button")).click();
//        sleep(1000);
//        $$(byText(text))
//                .first()
//                .click();
//
//    }
//    public static void tryToFindDoc(String text, String description) {
//        // ием по подписанту
//        if (!($(byText("Все задания")).isDisplayed())) {
//            $(byText("Мои задания")).click();
//        }
//        $(byText("Все задания")).click();
//        if ($(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div[1]/div/div[1]/div[1]/div[1]/div/button")).is(Condition.visible)) {
//            $(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div[1]/div/div[1]/div[1]/div[1]/div/button")).click();
//        }
//        if ($(".base-input").is(Condition.visible)) {
//            $(".base-input").setValue(text);
//        } else {
//
//            $(byXpath("//*[@id=\"desc\"]")).setValue(text);
//        }
//        if ($(".input-search-button").is(Condition.visible)) {
//            $(".input-search-button").click();
//        }
//        sleep(10000);
//        if ($(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div[1]/div/div[1]/div[1]/div[1]/div/div[4]/div[2]/button")).is(Condition.visible)) {
//
//            $(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div[1]/div/div[1]/div[1]/div[1]/div/div[4]/div[2]/button")).click();
//            sleep(1000);
//        }
//        $$(byText(description))
//                .first()
//                .click();
//        if ($("#desc").is(Condition.visible)) {
//            $("#desc").setValue(text);
//            sleep(10000);
//            $$(byText(description))
//                    .first()
//                    .click();
//        }
//
//    }


}
