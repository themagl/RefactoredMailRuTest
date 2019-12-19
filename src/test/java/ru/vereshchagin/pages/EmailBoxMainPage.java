package ru.vereshchagin.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class EmailBoxMainPage extends BasePage<EmailBoxMainPage>{

    @Step("Проверяем, что на странице появился блок с письмами")
    public boolean isEmailBoxOpened(){
        return $x("//div[@class='dataset-letters']").isDisplayed();
    }

    




}
