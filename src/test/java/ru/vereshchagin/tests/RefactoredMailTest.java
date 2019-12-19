package ru.vereshchagin.tests;

import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.testng.annotations.Test;
import ru.vereshchagin.pages.EmailBoxMainPage;
import ru.vereshchagin.pages.MainPage;

import static com.codeborne.selenide.Configuration.browser;
import static com.codeborne.selenide.Configuration.timeout;
import static com.codeborne.selenide.Configuration.startMaximized;
import static ru.vereshchagin.data.TestData.userLogin;
import static ru.vereshchagin.data.TestData.userPassword;

public class RefactoredMailTest {

    @BeforeEach
    public void openBrowser(){
        timeout = 10000;
        startMaximized = true;
        browser = "chrome";
    }

    @Test
    @Step("Пробуем войти в ящик")
    public void firstTest(){
        EmailBoxMainPage mailPage = new MainPage().openMainPage().logIntoMail(userLogin, userPassword);
    }
}
