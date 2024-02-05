package ru.zarwlad.qainterview.steps;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.chrome.ChromeOptions;
import ru.zarwlad.qainterview.pages.FactorialPage;

import java.time.Duration;

import static com.codeborne.selenide.Condition.partialText;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FactorialPageSteps {
    FactorialPage factorialPage = new FactorialPage();
    String result;

    @Когда("Происходит переход на страницу калькулятора")
     public void launchFactorialCalculator(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
        factorialPage = open(FactorialPage.url, FactorialPage.class);
    }

    @И("Вводится значение {string}")
    public void inputValue(String value){
        factorialPage.sendData(value);
        factorialPage.getResult().shouldHave(partialText("The factorial"), Duration.ofSeconds(1L));
        result = factorialPage.extractResult();

    }

    @Тогда("Ожидается результат {string}")
    public void expectedResult(String value){
        assertEquals(value, result);
    }
}
