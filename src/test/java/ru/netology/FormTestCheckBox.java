package ru.netology;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class FormTestCheckBox {
    @Test
    void shouldSubmitRequestInvalidCheckBox() {
        open("http://localhost:9999");

        $x("//div[@class='form-field form-field_size_m form-field_theme_alfa-on-white']//input[@name='name']")
                .setValue("Вася Пупкин");

        $x("//div[@class='form-field form-field_size_m form-field_theme_alfa-on-white']//input[@name='phone']")
                .setValue("+79210001020");

//        $x("//div[@class='form-field form-field_size_m form-field_theme_alfa-on-white']//label[@data-test-id='agreement']")
//                .click();

        $x("//div[@class='form-field form-field_size_m form-field_theme_alfa-on-white']//button[@class='button button_view_extra button_size_m button_theme_alfa-on-white']")
                .click();

        $x("//label[@class='checkbox checkbox_size_m checkbox_theme_alfa-on-white input_invalid']//span[@class='checkbox__text']").shouldHave(exactText("Я соглашаюсь с условиями обработки и использования моих персональных данных и разрешаю сделать запрос в бюро кредитных историй"));

    }
}
