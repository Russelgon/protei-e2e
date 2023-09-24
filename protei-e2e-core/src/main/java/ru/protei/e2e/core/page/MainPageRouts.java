package ru.protei.e2e.core.page;

import static ru.protei.e2e.core.tech.Driver.initializeDriver;

import ru.protei.e2e.core.data.Gender;
import ru.protei.e2e.core.data.MainPageData;

public class MainPageRouts {

    public MainPageRouts fillEmail(String email) {
        new MainPageData(initializeDriver()).setEmail(email);
        return this;
    }

    public MainPageRouts fillName(String name) {
        new MainPageData(initializeDriver()).setNameField(name);
        return this;
    }

    public MainPageRouts selectGender(Gender Gender) {
        new MainPageData(initializeDriver()).selectGender(Gender);
        return this;
    }

    public void clickAddButton() {
        new MainPageData(initializeDriver()).clickAddButton();
    }

    public void clickOkButton() {
        new MainPageData(initializeDriver()).clickOkButton();
    }

    public MainPageRouts click12Button() {
        new MainPageData(initializeDriver()).setSelect12();
        return this;
    }

    public MainPageRouts click21Button() {
        new MainPageData(initializeDriver()).setSelect21();
        return this;
    }

    public MainPageRouts click22Button() {
        new MainPageData(initializeDriver()).setSelect22();
        return this;
    }

    public String getSuccessMessage() {
        var message = new MainPageData(initializeDriver()).getSuccessMessage();
        return message;
    }

    public String getFailNameMessage() {
        var message = new MainPageData(initializeDriver()).getFailNameMessage();
        return message;
    }
}
