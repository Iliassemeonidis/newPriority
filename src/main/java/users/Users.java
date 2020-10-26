package users;

import com.codeborne.selenide.SelenideElement;
import pages.SignInPage;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class Users {

   public static final String AUTOTEST1 = "Автотест1 , Сотрудник, Департамент 1";
   public static final String AUTOTEST_TESTE_DEP = "Автотест1 , Сотрудник, Тестовый отдел";
   public static final String AUTOTEST3AT = "-, Автотест3 А. Т.";
   public static final String AUTOTEST3_A_T = "Автотест3 А. Т.";
   public static final String AUTOTEST1AT = "Автотест1 А. Т., Сотрудник, Тестовый отдел";
   public static final String AUTOTEST3LenEnergo = "Автотест3 А. Т.,ПАО \"ЛЕНЭНЕРГО\",Сотрудник 3";
   public static final String AUTOTEST1KubanEnergo = "Автотест1, Сотрудник, ПАО \"Кубаньэнерго\"";
   public static final String emploer3 = "Сотрудник3";
   public static final String emploer_3 = "Сотрудник 3";
   public static final String emploer1 = "Сотрудник1";
   public static final String DEPARTMENT1 = "Департамент 1";
   public static final String DEPARTMENT2 = "Департамент 2";
   public static final String DEPARTMENT3 = "Департамент 3";
   public static final String DEPARTMENT4 = "Департамент 4";
   public static final String DEPARTMENT5 = "Департамент 5";
   public static final String AUTOTEST_NAME1 = "Автотест1";
   public static final String AUTOTEST2 = "Автотест2 , Сотрудник, Департамент 2";
   public static final String AUTOTEST_NAME2 = "Автотест2";
   public static final String AUTOTEST3 = "Автотест3 , Сотрудник, Департамент 3";
   public static final String AUTOTEST_NAME3 = "Автотест3";
   public static final String AUTOTEST4 = "Автотест4 , Сотрудник, Департамент 4";
   public static final String AUTOTEST_NAME4 = "Автотест4";
   public static final String AUTOTEST5 = "Автотест5 , Сотрудник, Департамент 5";
   public static final String AUTOTEST_NAME5 = "Автотест5";
   public static final String AUTOTEST_ROSSET_NAME1 = "Автотест1, зам. начальника отдела, Тестовый отдел";
   public static final String AUTOTEST_ROSSET_NAME2 = "Автотест2, зам. начальника отдела, Тестовый отдел";
   public static final String AUTOTEST_ROSSET_NAME3 = "Автотест3, зам. начальника отдела, Тестовый отдел";
   public static final String AUTOTEST_ROSSET_NAME4 = "Автотест4, зам. начальника отдела, Тестовый отдел";
   public static final String AUTOTEST_ROSSET_NAME5 = "Автотест5, зам. начальника отдела, Тестовый отдел";
   public static final String AUTOTEST_KUB1 = "Автотест1, Сотрудник, Тестовый отдел";
   public static final String AUTOTEST_KUB2 = "Автотест2 , Сотрудник, Тестовый отдел";
//   public rivate static final String AUTOTEST_KUB2 = "Автотест2  , Сотрудник, Тестовый отдел" ;
   public static final String AUTOTEST_KUB3 = "Автотест3 , Сотрудник, Тестовый отдел";
   public static final String AUTOTEST_KUB4 = "Автотест4, Сотрудник, Тестовый отдел";
   public static final String AUTOTEST_KUB5 = "Автотест5, Сотрудник, Тестовый отдел";
   public static final String AUTOTEST_ROSSET_ORGAN_NAME1 = "Автотест1 А. Т.,ПАО \"Кубаньэнерго\",Сотрудник1";
   public static final String AUTOTEST_ROSSET_ORGAN_NAME2 = "Автотест2 А. Т.,ПАО \"Кубаньэнерго\",Сотрудник2";
   public static final String AUTOTEST_ROSSET_ORGAN_NAME3 = "Автотест3 А. Т.,ПАО \"Кубаньэнерго\",Сотрудник3";
   public static final String AUTOTEST_ROSSET_ORGAN_NAME4 = "Автотест4 А. Т.,ПАО \"Кубаньэнерго\",Сотрудник4";
   public static final String AUTOTEST_ROSSET_ORGAN_NAME5 = "Автотест5 А. Т.,ПАО \"Кубаньэнерго\",Сотрудник5";
   public static final String AUTOTEST1_TNT = "Автотест1 А. Т.,ООО \"Айди-Технологии управления\",Сотрудник1";
   public static final String AUTOTEST2_TNT = "Автотест2 А. Т.,ООО \"Айди-Технологии управления\",Сотрудник2";
   public static final String AUTOTEST3_AiDi = "Автотест3 А. Т.,ООО \"Айди-Технологии управления\",Сотрудник3";
   public static final String AUTOTEST4_TNT = "Автотест4 А. Т., Сотрудник4, ООО \"Айди-Технологии управления\"";
   public static final String AUTOTEST3_TNT = "Автотест3 А. Т., Сотрудник3, ООО \"Айди-Технологии управления\"";
   public static final String AUTOTEST5_TNT = "Автотест5 А. Т.,ООО \"Айди-Технологии управления\",Сотрудник5";
   public static final String AUTOTEST1_TNT_EMPLOER = "Автотест1 , Зам. начальник отдела, ООО \"Айди-Технологии управления\"";
   public static final String AUTOTEST2_TNT_EMPLOER = "Автотест2 , Зам. начальник отдела, ООО \"Айди-Технологии управления\"";
   public static final String AUTOTEST3_TNT_EMPLOER = "Автотест3 , Зам. начальник отдела, ООО \"Айди-Технологии управления\"";
   public static final String AUTOTEST4_TNT_EMPLOER = "Автотест4 , Зам. начальник отдела, ООО \"Айди-Технологии управления\"";
   public static final String AUTOTEST5_TNT_EMPLOER = "Автотест5 , Зам. начальник отдела, ООО \"Айди-Технологии управления\"";

   private static SelenideElement button3 = $("button.el-tooltip:nth-child(3)");
   private static SelenideElement button4 = $("button.el-tooltip:nth-child(4)");
   private static SelenideElement button5 = $("button.el-tooltip:nth-child(5)");
   private static SelenideElement exit = $(byText("Выход"));
   private static SelenideElement enter = $(byText("Войти"));
   private static SignInPage signInPage = new SignInPage();



   public static void exit() {
      sleep(10000);
      button4.click();
      if (!exit.isDisplayed()) {
         button5.click();
         if (!exit.isDisplayed()) {
            button3.click();
         }
      }
      sleep(1000);
     exit.click();


   }

   public static void comInBoss11() {
      sleep(10000);
      signInPage.inputLogin("Boss11");
      signInPage.inputPass("1");
      enter.click();
      sleep(1000);
   }

   public static void comInBoss12() {
      sleep(10000);
      signInPage.inputLogin("Boss12");
      signInPage.inputPass("1");
      enter.click();
      sleep(1000);
   }

   public static void comInBoss51() {
      sleep(1000);
      signInPage.inputLogin("Boss51");
      signInPage.inputPass("1");
      enter.click();
      sleep(1000);
   }

   public static void comInBoss31() {
      sleep(10000);
      signInPage.inputLogin("Boss31");
      signInPage.inputPass("1");
      enter.click();
      sleep(1000);
   }

   public static void comInBoss32() {
      sleep(10000);
      signInPage.inputLogin("Boss32");
      signInPage.inputPass("1");
      enter.click();
      sleep(1000);
   }

   public static void comInClerk2() {
      sleep(10000);
      signInPage.inputLogin("Clerk2");
      signInPage.inputPass("1");
      enter.click();
      sleep(1000);
   }

   public static void comInClerk3() {
      sleep(10000);
      signInPage.inputLogin("Clerk3");
      signInPage.inputPass("1");
      enter.click();
      sleep(1000);
   }

   public static void comInBoss21() {
      sleep(10000);
      signInPage.inputLogin("Boss21");
      signInPage.inputPass("1");
      enter.click();
      sleep(1000);
   }

   public static void comInAutotest1() {
      sleep(1000);
      signInPage.inputLogin("Autotest1");
      signInPage.inputPass("1");
      enter.click();
      sleep(1000);
   }

   public static void comInAutotest2() {
      sleep(1000);
      signInPage.inputLogin("Autotest2");
      signInPage.inputPass("1");
      enter.click();
      sleep(1000);
   }

   public static void comInAutotest3() {
      sleep(1000);
      signInPage.inputLogin("Autotest3");
      signInPage.inputPass("1");
      enter.click();
      sleep(1000);
   }

   public static void comInAutotest4() {
      sleep(1000);
      signInPage.inputLogin("Autotest4");
      signInPage.inputPass("1");
      enter.click();
      sleep(1000);
   }

   public static void comInAutotest5() {
      sleep(1000);
      signInPage.inputLogin("Autotest5");
      signInPage.inputPass("1");
      enter.click();
      sleep(1000);
   }








}
