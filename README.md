# ATM-Bilingual

## Описание проекта

"ATM-Bilingual" - это симулятор банкомата, поддерживающий два языка (английский и русский). Программа позволяет пользователям выполнять различные банковские операции, такие как просмотр баланса, внесение денег, снятие денег, просмотр выписки и изменение PIN-кода.

## Технологии

- **Java**: Основной язык программирования.
- **Maven**: Используется для управления зависимостями, сборки и запуска тестов.
- **JUnit 5**: Используется для написания и выполнения модульных тестов.

## Эффективность использования Java

В проекте "ATM-Bilingual" применены следующие конструкции и концепции Java, обеспечивающие его эффективность:

1. **Инкапсуляция**: Классы `BankAccount` и `Transaction` используют приватные поля и публичные методы для управления состоянием объектов, что помогает скрыть внутреннюю реализацию и обеспечивает контроль над доступом к данным.

2. **Полиморфизм и Наследование**: Проект не использует наследование напрямую, но концепция полиморфизма заложена в использовании интерфейсов и классов. Например, класс `ResourceBundle` используется для поддержки нескольких языков.

3. **Обработка исключений**: Исключения обрабатываются с помощью конструкций `try-catch`, что помогает избежать сбоя программы при возникновении ошибок. Это также улучшает пользовательский опыт, так как пользователи получают информативные сообщения об ошибках.

4. **Коллекции и Generics**: Использование коллекций, таких как `ArrayList`, позволяет эффективно управлять динамическими массивами данных. Generics обеспечивают безопасность типов, что уменьшает количество ошибок в коде.

5. **Юнит-тестирование**: Использование JUnit 5 для написания модульных тестов помогает выявить ошибки на ранней стадии и обеспечивает надежность и стабильность кода. Тесты проверяют основные методы класса `BankAccount` на корректность работы.
   
