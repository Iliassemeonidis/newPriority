Feature: Creat input document

  Scenario: create an input document and check how work "На рассмотрение" and "На резолюцию"
    Then Input login
    And Input password
    Then Click "Войти"

    Then Click "Создать документ"
    Then Click on document "ВХОДЯЩИЕ ДОКУМЕНТЫ"
    Then Click "Создать"
    And Wait
    Then if url equals Kuban Energo, upload document And Click "Далее"
    Then add correspondent
    And set reg_number and day of registration
    Then Click "Далее"
    But if "Проверка на дубли" is visible click on "Продолжить"
    Then Upload input document "Входящий документ.docx"
    Then Wait
    Then Click "Реквизиты"
    Then Wait
    Then Write description "Auto-test777"
    Then write delivery "Курьер"
    And  write thematic "Бизнес-процесс"

    Then Write addressee empl inputDoc "Автотест1"

    Then Write document kind "В"
    Then Write control date
    Then Click "Сохранить"
    And Wait
    Then Click "Зарегистрировать"
    And Wait
    And must not be visible "Не удалось выполнить действие"
    Then Click "На Рассмотрение"
    And Wait
    And must not be visible "Не удалось выполнить действие"
    Then Click "Реквизиты"
    Then status in "В канцелярии"




