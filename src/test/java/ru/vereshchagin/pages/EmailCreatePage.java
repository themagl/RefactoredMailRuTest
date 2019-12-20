package ru.vereshchagin.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import ru.vereshchagin.components.NavigateMenuBlock;

import static com.codeborne.selenide.Selenide.*;

public class EmailCreatePage extends BasePage<EmailCreatePage> {

    private NavigateMenuBlock navigate;

    private SelenideElement emailTakerAdressField = $x("//textarea[@data-original-name='To']");
    private SelenideElement newMailSubjectField = $x("//input[@name='Subject']");
    private SelenideElement iframe = $x("//iframe[starts-with(@id,'toolkit')]");
    private SelenideElement emailMessageField = $x("//body[@id='tinymce']");
    private SelenideElement sendButton = $x("//span[text()='Отправить']");
    private SelenideElement cancelButton = $x("//div[@title='Отмена']");

    @Step("Отправляем новое письмо по адресу {address}")
    public void sendNewEmail(String address, String subject, String message){
        emailTakerAdressField.sendKeys(address);
        newMailSubjectField.sendKeys(subject);
        switchTo().frame(iframe);
        emailMessageField.clear();
        emailMessageField.sendKeys(message);
        switchTo().defaultContent();
        sendButton.click();
    }


    @Step("Переходим во Входящие")
    public EmailBoxMainPage goInbox(){
        navigate.goToInbox();
        return page(EmailBoxMainPage.class);
    }



}
