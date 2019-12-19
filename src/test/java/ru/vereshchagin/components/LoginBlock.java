package ru.vereshchagin.components;

import com.codeborne.selenide.ElementsContainer;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class LoginBlock extends ElementsContainer {

    private static final SelenideElement MAILBOX_LOGINFIELD = $x("//*[@name='login']");
    private static final SelenideElement MAILBOX_PASSWORDFIELD = $x("//*[@name='password']");
    private static final SelenideElement SUBMIT_BUTTON = $x("//input[@type='submit']");

    public void logIntoMailBox(String login, String password){
        MAILBOX_LOGINFIELD.sendKeys(login);
        SUBMIT_BUTTON.click();
        MAILBOX_PASSWORDFIELD.sendKeys(password);
        SUBMIT_BUTTON.click();
    }


}
