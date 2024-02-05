package ru.zarwlad.qainterview;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import ru.zarwlad.qainterview.pages.FactorialPage;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static org.junit.jupiter.api.Assertions.*;

import static com.codeborne.selenide.Selenide.*;

public class FactorialPageTest {
    FactorialPage factorialPage = new FactorialPage();

    @BeforeAll
    public static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");

    }

    @BeforeEach
    public void setUp() {
        factorialPage = open(FactorialPage.url, FactorialPage.class);
    }

    @AfterAll
    public static void finish(){
        closeWebDriver();
    }

    @Test
    public void testFactorial_5_is_120() {
        factorialPage.sendData("5");
        factorialPage.getResult().shouldHave(partialText("The factorial"), Duration.ofSeconds(1L));
        assertEquals("120", factorialPage.extractResult());
    }

    @Test
    public void testNative(){
        $(By.id("number")).sendKeys("5");
        $(By.id("getFactorial")).click();
        $(By.id("resultDiv")).shouldHave(Condition.partialText("The factorial"), Duration.ofSeconds(3L));
        String text = $(By.id("resultDiv")).text();
        assertEquals("The factorial of 5 is: 120", text);
    }
}
