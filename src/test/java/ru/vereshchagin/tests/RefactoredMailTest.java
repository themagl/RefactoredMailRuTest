package ru.vereshchagin.tests;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ru.vereshchagin.pages.EmailBoxMainPage;
import ru.vereshchagin.pages.EmailCreatePage;
import ru.vereshchagin.pages.FolderSettingsPage;
import ru.vereshchagin.pages.MainPage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static com.codeborne.selenide.Configuration.browser;
import static com.codeborne.selenide.Configuration.timeout;
import static com.codeborne.selenide.Configuration.startMaximized;
import static org.testng.Assert.assertTrue;
import static ru.vereshchagin.data.TestData.*;

public class RefactoredMailTest {

    @BeforeTest
    public void openBrowser() {
        timeout = 10000;
        startMaximized = true;
        browser = "chrome";
    }

    @DataProvider
    public static Object[][] credentialsProvider() {
        return new Object[][]{
                {"theselenidetest@mail.ru", "Autotest1"},
        };
    }

    @Test(dataProvider = "credentialsProvider")
    @Parameters({"Login", "Password"})
    @Step("Проверяем валидность логина и пароля, количество писем в ящике и наличие письма с конкретным сообщением.")
    public void firstTest(String userLogin, String userPassword) {
        EmailBoxMainPage mailPage = new MainPage().openMainPage().logIntoMail(userLogin, userPassword);
        mailPage.waitMailBlockDisplayed();
        mailPage.messageListCount(5);
        mailPage.findMailByText(piCheck);
        makeScreen("mainPageScreen");
    }

    @Test(dataProvider = "credentialsProvider")
    @Parameters({"Login", "Password"})
    @Step("Входим в почтовый ящик, отправляем себе письмо, затем проверяем его наличие, удаляем его и проверяем наличие в корзине.")
    public void secondTest(String userLogin, String userPassword) {
        EmailBoxMainPage mainPage = new MainPage().openMainPage().logIntoMail(userLogin, userPassword);
        EmailCreatePage createPage = mainPage.createNewEmailForm();
        createPage.sendNewEmail(userLogin, messageSubject, messageText);
        mainPage = createPage.goInbox();
        mainPage.findMailByText(messageText);
        mainPage.deleteEmail(messageText);
        mainPage = mainPage.goToGarbage();
        mainPage.findMailByText(messageText);
    }

    @Test(dataProvider = "credentialsProvider")
    @Parameters({"Login", "Password"})
    @Step("Создаем письмо и выходим без сохранения. Проверяем папку Черновики на наличие появившегося элемента.")
    public void thirdTest(String userLogin, String userPassword) {

    }

    @Test(dataProvider = "credentialsProvider")
    @Parameters({"Login", "Password"})
    @Step("Заходим в настройки папок почтового ящика, создаем новую папку, проверяем ее наличие. Затем удаляем ее и проверяем отсутствие.")
    public void fourthTest(String userLogin, String userPassword) {
        EmailBoxMainPage mainPage = new MainPage().openMainPage().logIntoMail(userLogin, userPassword);
        FolderSettingsPage settings = mainPage.goToFoldersSettings();
//        settings.createNewFolder("Folder123");
//        settings.hoverAndDeleteFolder("Folder123");
    }


    @Attachment(value = "Прикрепляем скриншот", type = "image/png")
    public Object makeScreen(String screenName) {
        try {
            return Files.readAllBytes(Paths.get(Selenide.screenshot(screenName)));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
