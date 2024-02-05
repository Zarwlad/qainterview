package ru.zarwlad.qainterview;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import ru.zarwlad.qainterview.pages.ExampleFactorialPage;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static org.junit.jupiter.api.Assertions.*;

import static com.codeborne.selenide.Selenide.*;

public class ExampleFactorialPageTest {
    ExampleFactorialPage exampleFactorialPage = new ExampleFactorialPage();

    @BeforeAll
    public static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");

    }

    @BeforeEach
    public void setUp() {
        exampleFactorialPage = open(ExampleFactorialPage.url, ExampleFactorialPage.class);
    }

    @AfterAll
    public static void finish(){
        closeWebDriver();
    }

    @Test
    public void testPageObjectFactorial_5_is_120() {
        exampleFactorialPage.sendData("5");
        exampleFactorialPage.getResult().shouldHave(partialText("The factorial"), Duration.ofSeconds(1L));
        assertEquals("120", exampleFactorialPage.extractResult());
    }

    @Test
    public void testNativeSelenide_5_is_120(){
        $(By.id("number")).sendKeys("5");
        $(By.id("getFactorial")).click();
        $(By.id("resultDiv")).shouldHave(Condition.partialText("The factorial"), Duration.ofSeconds(1L));
        String text = $(By.id("resultDiv")).text();
        assertEquals("The factorial of 5 is: 120", text);
    }
}
