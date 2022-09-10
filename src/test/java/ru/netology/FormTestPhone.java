package ru.netology;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class FormTestPhone {
    @Test
    void shouldSubmitRequestInvalidPhone() {
        open("http://localhost:9999");

        $x("//*[@data-test-id='name']//input")
                .setValue("Вася Пупкин");

        $x("//*[@data-test-id='phone']//input")
                .setValue("+792100");

        $x("//span[@class='checkbox__box']")
                .click();

        $x("//span[@class='button__content']")
                .click();

        $x("//*[@data-test-id='phone']//span[@class='input__sub']")
                .shouldHave(exactText("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));

    }
}
