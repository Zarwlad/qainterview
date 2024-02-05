package ru.zarwlad.qainterview.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class ExampleFactorialPage {
    public static final String url = "https://qainterview.pythonanywhere.com/";

    @FindBy(xpath = "//input[@id=\"number\"]")
    private SelenideElement inputField;

    @FindBy(xpath = "//button[@id=\"getFactorial\"]")
    private SelenideElement button;

    @FindBy(xpath = "//p[@id=\"resultDiv\"]")
    private SelenideElement result;

    public String extractResult(){
        String[] data = result.text().split(": ");
        return data[data.length-1];
    }

    public void sendData(String value){
        inputField.sendKeys(value);
        button.click();
    }

    public SelenideElement getInputField() {
        return inputField;
    }

    public void setInputField(SelenideElement inputField) {
        this.inputField = inputField;
    }

    public SelenideElement getButton() {
        return button;
    }

    public void setButton(SelenideElement button) {
        this.button = button;
    }

    public SelenideElement getResult() {
        return result;
    }

    public void setResult(SelenideElement result) {
        this.result = result;
    }
}
