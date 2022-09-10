package ru.netology;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.*;

public class FormTest {

    @Test
    void shouldSubmitRequest() {
        open("http://localhost:9999");

        $x("//*[@data-test-id='name']//input")
                .setValue("Вася Пупкин");

        $x("//*[@data-test-id='phone']//input")
                .setValue("+79210001020");

        $x("//span[@class='checkbox__box']")
                .click();

        $x("//span[@class='button__content']")
                .click();

        $x("//*[@data-test-id='order-success']")
                .shouldHave(exactText("Ваша заявка успешно отправлена! " +
                        "Наш менеджер свяжется с вами в ближайшее время."));
    }
}
