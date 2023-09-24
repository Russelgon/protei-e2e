package ru.protei.e2e.core.tech;

import ru.protei.e2e.core.page.AssertPages;
import ru.protei.e2e.core.page.AuthorizationPageRouts;
import ru.protei.e2e.core.page.MainPageRouts;

public abstract class Routs {

    protected final AuthorizationPageRouts authorizationPage = new AuthorizationPageRouts();
    protected final MainPageRouts mainPage = new MainPageRouts();
    protected final AssertPages assertPages = new AssertPages();

}


