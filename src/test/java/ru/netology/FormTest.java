package ru.netology;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.params.shadow.com.univocity.parsers.conversions.Conversions.trim;

public class FormTest {

    @Test
    void shouldSubmitRequest() {
        open("http://localhost:9999");

        $x("//div[@class='form-field form-field_size_m form-field_theme_alfa-on-white']//input[@name='name']")
                .setValue("Вася Пупкин");

        $x("//div[@class='form-field form-field_size_m form-field_theme_alfa-on-white']//input[@name='phone']")
                .setValue("+79210001020");

        $x("//div[@class='form-field form-field_size_m form-field_theme_alfa-on-white']//label[@data-test-id='agreement']")
                .click();

        $x("//div[@class='form-field form-field_size_m form-field_theme_alfa-on-white']//button[@class='button button_view_extra button_size_m button_theme_alfa-on-white']")
                .click();

        $(".Success_successBlock__2L3Cw").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));

    }

    @Test
    void shouldSubmitRequestInvalidName() {
        open("http://localhost:9999");

        $x("//div[@class='form-field form-field_size_m form-field_theme_alfa-on-white']//input[@name='name']")
                .setValue("Vasya Pupkin");

        $x("//div[@class='form-field form-field_size_m form-field_theme_alfa-on-white']//input[@name='phone']")
                .setValue("+79210001020");

        $x("//div[@class='form-field form-field_size_m form-field_theme_alfa-on-white']//label[@data-test-id='agreement']")
                .click();

        $x("//div[@class='form-field form-field_size_m form-field_theme_alfa-on-white']//button[@class='button button_view_extra button_size_m button_theme_alfa-on-white']")
                .click();

        $x("//span[@class='input input_type_text input_view_default input_size_m input_width_available input_has-label input_has-value input_invalid input_theme_alfa-on-white']//span[@class='input__sub']").shouldHave(exactText("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы."));

    }

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
