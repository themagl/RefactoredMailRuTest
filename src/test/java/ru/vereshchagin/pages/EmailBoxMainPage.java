package ru.vereshchagin.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.jsoup.select.Evaluator;
import org.openqa.selenium.By;
import ru.vereshchagin.components.ActionBar;
import ru.vereshchagin.components.NavigateMenuBlock;

import java.util.stream.Collectors;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static ru.vereshchagin.data.TestData.messageText;

public class EmailBoxMainPage extends BasePage<EmailBoxMainPage> {

    private NavigateMenuBlock navigate;
    private ActionBar actionBar;

    private SelenideElement newEmailButton = $x("//span[text()='Написать письмо']");
    private SelenideElement mailBlock = $x("//*[@id='b-letters']");
    private ElementsCollection messageRows = $$("#b-letters .b-datalist__body > div");
    private SelenideElement emailByText;

    @Step("Проверяем, что на странице появился блок с письмами")
    public void waitMailBlockDisplayed() {
        mailBlock.should(Condition.exist);
    }

    @Step("Проверяем, что в блоке содержится {count} писем")
    public void messageListCount(int count) {
        messageRows.shouldHaveSize(count);
    }

    @Step("Проверяем, что в письме под номером {index} содержится сообщение {message}")
    public void messageContentCheck(int index, String message) {
        messageRows.get(index).should(text(message));
    }

    @Step("Переходим на форму создания нового письма")
    public EmailCreatePage createNewEmailForm() {
        newEmailButton.click();
        return page(EmailCreatePage.class);
    }

    @Step("Удаляем письмо с сообщением {message}")
    public void deleteEmail(String message) {
//        messageRows.get(index).$x("..//div[@class='b-checkbox__box']").click();
//        actionBar.deleteButtonClick();
        messageRows.stream().filter((s) -> s.getText().contains(message)).collect(Collectors.toList()).get(0).$x("..//div[@class='b-checkbox__box']").click();
        actionBar.deleteButtonClick();

    }

    @Step("Переходим в Корзину")
    public EmailBoxMainPage goToGarbage() {
        navigate.goToGarbage();
        return page(EmailBoxMainPage.class);
    }

    @Step("Находим в ящике письмо, содержащее {message}")
    public void findMailByText(String message) {
        $x(String.format("//*[text()='%s']", message)).should(visible);
    }
}
