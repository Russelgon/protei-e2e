package ru.protei.e2e.testing.ui.tests;

import static ru.protei.e2e.core.tech.Driver.initializeDriver;
import static ru.protei.e2e.core.tech.RandomString.Rus;
import static ru.protei.e2e.core.tech.RandomString.randomLengthString;

import jdk.jfr.Name;
import org.junit.After;
import org.junit.Test;
import ru.protei.e2e.core.data.DataLoader;
import ru.protei.e2e.core.tech.Routs;

public class MainPageUiTest extends Routs {

    @After
    public void closeDriver() {
        initializeDriver().close();
    }

    @Test
    @Name("TEST_1. UI. Главная страница. Данные успешно внесены")
    public void TEST_1_UI__Main_Page__Data_was_correctly_added() throws InterruptedException {

        // Шаг 1.1 Подготовка данных
        var userPositive = DataLoader.projectPositiveUser();
        var name = randomLengthString(4, 6, Rus);
        var expectedMessage = "Данные добавлены.";

        // Шаг 2.1 Формирование действий
        authorizationPage
                .fillEmail(userPositive.getMail())
                .fillPassword(userPositive.getPassword())
                .clickLoginButton();
        mainPage
                .fillEmail(userPositive.getMail())
                .fillName(name)
                .selectGender(userPositive.getGender())
                .click12Button()
                .click22Button()
                .clickAddButton();

        // Шаг 3.1 Проверка результатов отправки запроса
        Thread.sleep(2000);
        assertPages.assertMessage(mainPage.getSuccessMessage(), expectedMessage);
        assertPages.assertThatTableRowCorrect(userPositive.getMail(), name, userPositive.getGender().getVisibleText(), "2.2");
    }

    @Test
    @Name("TEST_1. UI. Главная страница. Поле имя - пустое")
    public void TEST_1_UI__Main_Page__Name_fiel_is_empty() throws InterruptedException {

        // Шаг 1.1 Подготовка данных
        var userPositive = DataLoader.projectPositiveUser();
        var name = randomLengthString(4, 6, Rus);
        var expectedMessage = "Поле имя не может быть пустым";

        // Шаг 2.1 Формирование действий
        authorizationPage
                .fillEmail(userPositive.getMail())
                .fillPassword(userPositive.getPassword())
                .clickLoginButton();
        mainPage
                .fillEmail(userPositive.getMail())
                .selectGender(userPositive.getGender())
                .click12Button()
                .click22Button()
                .clickAddButton();

        // Шаг 3.1 Проверка результатов отправки запроса
        Thread.sleep(2000);
        assertPages.assertMessage(mainPage.getFailNameMessage(), expectedMessage);
    }
}
