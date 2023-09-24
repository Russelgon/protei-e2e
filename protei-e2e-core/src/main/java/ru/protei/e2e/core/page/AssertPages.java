package ru.protei.e2e.core.page;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.fail;

import java.util.List;
import java.util.stream.Collectors;
import org.hamcrest.CoreMatchers;
import org.hamcrest.Matcher;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.protei.e2e.core.tech.Driver;

public class AssertPages extends Driver {

    //************** MAIN PAGE ASSET *******************************************************************
    public void assertThatTableRowCorrect(String email, String name, String gender, String value) {

        try {
            List<WebElement> rows = initializeDriver().findElements(
                    By.xpath("//table[@id='dataTable']/tbody/tr"));
            assertThat(rows.size(), (equalTo(1)));
            List<WebElement> cells = rows.get(0).findElements(By.tagName("td"));
            assertThat(cells.size(), (equalTo(5)));

            Matcher<Iterable<? super String>> matcher = CoreMatchers.allOf(
                    CoreMatchers.hasItem(email),
                    CoreMatchers.hasItem(name),
                    CoreMatchers.hasItem(gender),
                    CoreMatchers.hasItem(value)
            );

            assertThat(cells.stream().map(WebElement::getText).collect(Collectors.toList()),
                    matcher);
        } catch (Exception e) {
            e.printStackTrace();
            fail("Test failed due to an exception: " + e.getMessage());
        }
    }

    public void assertMessage(String successMessage, String expectedMessage) {
        try {
            assertThat(successMessage, (equalTo(expectedMessage)));
        } catch (Exception e) {
            e.printStackTrace();
            fail("Test failed due to an exception: " + e.getMessage());
        }
    }

//    public void assertThatTableRowIsEmpty() {
//        // TODO: 25.09.2023
//        if (tbody.getText().isEmpty()) {
//            System.out.println("Таблица пуста");
//        } else {
//            System.out.println("Таблица не пуста");
//        }
//    }
}
