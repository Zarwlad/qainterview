package ru.zarwlad.qainterview;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class AdvancedFactorialPageTest {

    /*
     Напишите тесты по проверке функционала калькулятора факториала, используя junit5, Selenide или Selenium.
     */

    @BeforeAll
    public static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterAll
    public static void finish(){
        closeWebDriver();
    }
}
