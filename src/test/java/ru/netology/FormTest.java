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
}
