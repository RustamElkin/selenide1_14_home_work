package tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;

public class CheckAvailabilityOfPagesOnGitHubTest {

    @BeforeAll
    static void configure() {
        baseUrl = "https://github.com";
    }

    @Test
    void checkCodeForJUnitOnGithub() {

        // - Откройте страницу Selenide в Github
        open( "/selenide/selenide");

        // - Перейдите в раздел Wiki проекта
        $$("nav li").findBy(text("Wiki")).click();

        // - Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
        // - Откройте страницу SoftAssertions
        $("#wiki-pages-filter").setValue("SoftAssertions").pressEnter();
        $$("#wiki-pages-box a").findBy(exactText("SoftAssertions")).click();

        // - проверьте что внутри есть пример кода для JUnit5
        $(".markdown-body").shouldHave(text("Using JUnit5 extend test class"));
    }
}
