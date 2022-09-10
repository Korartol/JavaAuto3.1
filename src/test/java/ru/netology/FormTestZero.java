package ru.netology;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class FormTestZero {
    @Test
    void shouldSubmitRequestInvalidForms() {
        open("http://localhost:9999");

        $x("//span[@class='button__content']")
                .click();

        $x("//*[@data-test-id='name'][contains(@class, 'input_invalid')]//span[@class='input__sub']")
                .shouldHave(exactText("Поле обязательно для заполнения"));
    }

    @Test
    void shouldSubmitRequestInvalidNameZero() {
        open("http://localhost:9999");

        $x("//*[@data-test-id='phone']//input")
                .setValue("+79210001020");

        $x("//span[@class='checkbox__box']")
                .click();

        $x("//span[@class='button__content']")
                .click();

        $x("//*[@data-test-id='name'][contains(@class, 'input_invalid')]//span[@class='input__sub']")
                .shouldHave(exactText("Поле обязательно для заполнения"));
    }

    @Test
    void shouldSubmitRequestInvalidPhoneZero() {
        open("http://localhost:9999");

        $x("//*[@data-test-id='name']//input")
                .setValue("Вася Пупкин");

        $x("//span[@class='checkbox__box']")
                .click();

        $x("//span[@class='button__content']")
                .click();

        $x("//*[@data-test-id='phone'][contains(@class, 'input_invalid')]//span[@class='input__sub']")
                .shouldHave(exactText("Поле обязательно для заполнения"));
    }
}
