import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class WebSteps {

    @Step("��������� ������� ��������")
    public void openMainPage() {
        open("https://github.com");
    }

    @Step("���� ����������� {repo}")
    public void searchForRepository(String repo) {
        $(".search-input").click();
        $("#query-builder-test").sendKeys("eroshenkoam/allure-example");
        $("#query-builder-test").pressEnter();
    }

    @Step("������� �� ������ ����������� {repo}")
    public void clickOnRepositoryLink(String repo) {
        $(linkText("eroshenkoam/allure-example")).click();
    }

    @Step("��������� ��� Issues")
    public void openIssuesTab() {
        $("#issues-tab").click();
    }

    @Step("��������� ������� Issue � ������� {issue}")
    public void shouldSeeIssueWithNumber(String issue) {
        $(withText("69 nice")).should(Condition.exist);
    }
}
