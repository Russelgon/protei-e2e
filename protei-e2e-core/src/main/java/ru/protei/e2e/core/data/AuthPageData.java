package ru.protei.e2e.core.data;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AuthPageData {

    @FindBy(id = "loginPassword")
    private WebElement passwordField;
    @FindBy(id = "loginEmail")
    private WebElement emailField;
    @FindBy(id = "authButton")
    private WebElement authButton;


    public AuthPageData(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void setEmail(String email) {
        emailField.sendKeys(email);
    }

    public void setPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        authButton.click();
    }
}
