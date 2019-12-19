package ru.vereshchagin.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class EmailCreatePage extends BasePage<EmailCreatePage> {

    private SelenideElement emailTakerAdress = $x("//textarea[@data-original-name='To']");
    private SelenideElement newMailSubject = $x("//input[@name='Subject']");
    private SelenideElement iframe = $x("//iframe[starts-with(@id,'toolkit')]");
    private SelenideElement sendButton = $x("//span[text()='Отправить']");
    private SelenideElement cancelButton = $x("//div[@title='Отмена']");

    public void sendNewEmail(){

    }



}
