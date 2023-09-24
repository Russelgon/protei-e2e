package ru.protei.e2e.core.page;

import static ru.protei.e2e.core.tech.Driver.initializeDriver;

import ru.protei.e2e.core.data.AuthPageData;

public class AuthorizationPageRouts {

    public AuthorizationPageRouts fillEmail(String email) {
        new AuthPageData(initializeDriver()).setEmail(email);
        return this;
    }

    public AuthorizationPageRouts fillPassword(String password) {
        new AuthPageData(initializeDriver()).setPassword(password);
        return this;
    }

    public void clickLoginButton() {
        new AuthPageData(initializeDriver()).clickLoginButton();
    }
}


