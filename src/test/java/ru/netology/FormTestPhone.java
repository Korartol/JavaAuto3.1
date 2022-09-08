package ru.netology;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class FormTestPhone {
    @Test
    void shouldSubmitRequestInvalidPhone() {
        open("http://localhost:9999");

        $x("//div[@class='form-field form-field_size_m form-field_theme_alfa-on-white']//input[@name='name']")
                .setValue("Вася Пупкин");

        $x("//div[@class='form-field form-field_size_m form-field_theme_alfa-on-white']//input[@name='phone']")
                .setValue("898989");

        $x("//div[@class='form-field form-field_size_m form-field_theme_alfa-on-white']//label[@data-test-id='agreement']")
                .click();

        $x("//div[@class='form-field form-field_size_m form-field_theme_alfa-on-white']//button[@class='button button_view_extra button_size_m button_theme_alfa-on-white']")
                .click();

        $x("//span[@class='input input_type_tel input_view_default input_size_m input_width_available input_has-label input_has-value input_invalid input_theme_alfa-on-white']//span[@class='input__sub']").shouldHave(exactText("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));

    }
}
