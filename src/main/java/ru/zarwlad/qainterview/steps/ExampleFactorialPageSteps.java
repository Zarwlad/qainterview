package ru.zarwlad.qainterview.steps;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import io.qameta.allure.selenide.AllureSelenide;
import ru.zarwlad.qainterview.pages.ExampleFactorialPage;

import java.time.Duration;

import static com.codeborne.selenide.Condition.partialText;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExampleFactorialPageSteps {
    ExampleFactorialPage exampleFactorialPage = new ExampleFactorialPage();
    String result;

    @Когда("происходит переход на страницу калькулятора")
     public void launchFactorialCalculator(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        exampleFactorialPage = open(ExampleFactorialPage.url, ExampleFactorialPage.class);
    }

    @И("вводится значение {string}")
    public void inputValue(String value){
        exampleFactorialPage.sendData(value);
        exampleFactorialPage.getResult().shouldHave(partialText("The factorial"), Duration.ofSeconds(1L));
        result = exampleFactorialPage.extractResult();
    }

    @Тогда("ожидается результат {string}")
    public void expectedResult(String value){
        assertEquals(value, result);
    }
}
