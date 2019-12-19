package ru.vereshchagin.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class EmailBoxMainPage extends BasePage<EmailBoxMainPage> {

    private SelenideElement newEmailButton = $x("//span[text()='Написать письмо']");
    private SelenideElement mailBlock = $x("//*[@id='b-letters']");
    private ElementsCollection messageRows = $$("#b-letters .b-datalist__body > div");

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
}
