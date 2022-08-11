package selenide1;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.byText;

public class SelenideWikiTest {

    @BeforeAll
    static void configure() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1440x1280";
    }

    @Test
    void selenideWiki() {

        open("https://github.com/");
        $("[data-test-selector=nav-search-input]").setValue("selenide").pressEnter();
        $("ul.repo-list li").$("a").click();
        $("#wiki-tab").click();
        $("#wiki-body").shouldHave(text("Soft assertions"));
        $("#wiki-body").find(byText("Soft assertions")).click();
        $("#wiki-content").shouldHave(text("Using JUnit5 extend test class"));
    }
}
