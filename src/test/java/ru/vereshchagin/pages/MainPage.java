package ru.vereshchagin.pages;

import io.qameta.allure.Step;
import ru.vereshchagin.components.LoginBlock;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class MainPage extends BasePage<MainPage>{

    private LoginBlock loginBlock;

    @Step("Открываем главную страницу")
    public static MainPage openMainPage(){
        open("https://mail.ru");
        return page(MainPage.class);
    }

    @Step("Заходим в ящик по логину {login} и паролю {password}")
    public EmailBoxMainPage logIntoMail(String login, String password){
        loginBlock.logIntoMailBox(login, password);
        return page(EmailBoxMainPage.class);
    }


}
