package ru.netology;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class FormTestName {
    @Test
    void shouldSubmitRequestInvalidName() {
        open("http://localhost:9999");

        $x("//*[@data-test-id='name']//input")
                .setValue("Vasya Pupkin");

        $x("//*[@data-test-id='phone']//input")
                .setValue("+79210001020");

        $x("//span[@class='checkbox__box']")
                .click();

        $x("//span[@class='button__content']")
                .click();

        $x("//*[@data-test-id='name'][contains(@class, 'input_invalid')]//*[@class='input__sub']")
                .shouldHave(exactText("Имя и Фамилия указаные неверно. Допустимы только русские буквы, " +
                        "пробелы и дефисы."));
    }
}
