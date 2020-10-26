Feature: OUTPUT DOCUMENT for Smok

  Scenario: OUTPUT DOCUMENT for Smok
    Then Input login
    And Input password
    Then Click "Войти"

    Then Click "Создать документ"
    Then Click on document "ИСХОДЯЩИЕ ДОКУМЕНТЫ"
    Then Click "Создать"
    And Wait

    Then Upload document "Договор поставки.doc"
    And Wait
    Then Click "Реквизиты"
    Then Write stamp "Общего пользования"
    Then Write description "Auto-test777"
    Then Singer "Автотест2"
    And Wait
    Then complete the document kind
    Then Write thematic "Бизнес-процесс"
    Then Write addressee empl output doc "Автотест4"
    And Click "Сохранить"
    And Wait
    Then Click "Контент"
    Then Click "Реквизиты"
    Then Wait
    Then Copy "Регистрационный номер"


    Then Click "Согласование и подписание"
    Then Add a checkout stage
    And Crete design reviewer "Автотест3"
    Then Wait
    Then Add a approval stage and add approver "Автотест4"
    Then Wait
    Then Click "На согласование"
    Then Wait
    Then Go to "Автотест3"
    Then try to find document use the document's registration number
    And Wait
    Then Click "Контент"
    And Download content
    Then upload more content
    And Wait











