package ru.netology;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class FormTestCheckBox {
    @Test
    void shouldSubmitRequestInvalidCheckBox() {
        open("http://localhost:9999");

        $x("//*[@data-test-id='name']//input")
                .setValue("Вася Пупкин");

        $x("//*[@data-test-id='phone']//input")
                .setValue("+79210001020");

        $x("//span[@class='button__content']")
                .click();
        $x("//*[contains(@class, 'input_invalid')]//*[@class='checkbox__text']")
                .shouldHave(exactText("Я соглашаюсь с условиями обработки и использования моих " +
                        "персональных данных и разрешаю сделать запрос в бюро кредитных историй"));
    }
}
