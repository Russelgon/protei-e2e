package ru.protei.e2e.core.data;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class MainPageData {

    @FindBy(id = "dataEmail")
    private WebElement emailField;
    @FindBy(id = "dataName")
    private WebElement nameField;
    @FindBy(id = "dataGender")
    private WebElement genderField;
    @FindBy(xpath = "/html/body/div[2]/form/div[6]/input")
    private WebElement select12;
    @FindBy(xpath = "/html/body/div[2]/form/div[7]/input")
    private WebElement select21;
    @FindBy(xpath = "/html/body/div[2]/form/div[8]/input")
    private WebElement select22;
    @FindBy(id = "dataSend")
    private WebElement addButton;
    @FindBy(xpath = "/html/body/div[3]/div/div/div[1]")
    private WebElement successMessage;
    @FindBy(className = "uk-button-primary")
    private WebElement okButton;
    @FindBy(className ="uk-alert-danger")
    private WebElement failNameMessage;



    public MainPageData(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void setEmail(String email) {
        emailField.sendKeys(email);
    }

    public void setNameField(String name) {
        nameField.sendKeys(name);
    }

    public void setSelect12() {
        select12.click();
    }

    public void setSelect21() {
        select21.click();
    }

    public void setSelect22() {
        select22.click();
    }

    public void clickAddButton() {
        addButton.click();
    }

    public void selectGender(Gender gender) {
        Select select = new Select(genderField);
        select.selectByVisibleText(gender.getVisibleText());
    }

    public void clickOkButton() {
        okButton.click();
    }

    public String getSuccessMessage() {
        return successMessage.getText().toString();
    }

    public String getFailNameMessage() {
        return failNameMessage.getText().toString();
    }
}
