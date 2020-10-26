Feature: Order for Smoke

  Scenario: create an order and run it
  through all stages of the life cycle according to the smoke scenario

    Then Input login
    Then Input password
    Then Click "Войти"

    Then Click "Создать документ"
    Then Click "РАСПОРЯДИТЕЛЬНЫЕ ДОКУМЕНТЫ"
    Then Click on document "Приказ (общий)"
    Then Click "Создать"
    Then Wait

    Then Upload document "Приказ об изменении орг-штатной структуры.docx"
    Then Wait
    Then Click "Реквизиты"
    Then Write stamp "Общего пользования"
    Then Write description "Auto-test777"
    Then Singer "Автотест2"
    Then Wait
    Then Write thematic "Бизнес-процесс"
    Then Click "Сохранить"
    Then Wait
    Then Click "Контент"
    Then Click "Реквизиты"
    Then Wait
    Then Copy "Регистрационный номер"


    Then Click "Согласование и подписание"
    Then Set complete condition "Ждать первой визы"
    Then Add a checkout stage
    And Crete design reviewer "Автотест3"
    Then Wait
    Then Add a approval stage and add approver "Автотест4"
    Then Wait
    And Add approver "Автотест5"
    Then Wait
    Then Click "На согласование"
    Then Wait
    Then Go to "Автотест3"
    Then try to find document use the document's registration number
    Then Download content
    Then Click "Вернуть"
    Then Upload content for answer and write description "Отклоняем для теста"
    Then Click on "Вернуть"
    Then Go to "Автотест1"
    Then try to find document use the document's registration number
    Then Click "Отправить повторно"
    Then Go to "Автотест3"
    Then try to find document use the document's registration number
    Then Click "Завершить"
    Then Go to "Автотест4"
    Then try to find document use the document's registration number
    Then Click "Отклонить"
    Then Upload content for answer and write description "Отклоняем для теста"
    Then Click on "Отклонить"
    Then Go to "Автотест1"
    Then try to find document use the document's registration number
    Then Click "Всем, кто не согласовал на текущем этапе"
    Then Go to "Автотест4"
    Then try to find document use the document's registration number
    Then Click "Согласовать"
    Then Go to "Автотест5"
    Then try to find document use the document's registration number
    Then Click "Согласовать"
    Then Go to "Автотест2"
    Then try to find document use the document's registration number
    Then Click "Отклонить"
    Then Upload content for answer and write description "Отклоняем для теста"
    Then Click on "Отклонить"
    Then Go to "Автотест1"
    Then try to find document use the document's registration number
    Then Click "На подписание"
    Then Go to "Автотест2"
    Then try to find document use the document's registration number
    Then Click "Подписать"
    Then Wait
    Then Click "Реквизиты"
    Then Wait
    Then Wait
    Then Copy "Регистрационный номер"
    Then Click "Создать резолюцию"
    Then Complete the Resolution
    Then Click "Печать карточки"
    Then Click "Печать"
    Then should not be visible "Произошла ошибка при формировании документа"
    Then Go to "Автотест5"
    Then try to find document use the document's registration number
    Then Click "Исполнить"
    Then Upload content for answer and write description "The end"
    Then Click on "Отправить"
    Then Wait















    


