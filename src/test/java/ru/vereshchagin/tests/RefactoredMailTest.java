package ru.vereshchagin.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Configuration.browser;
import static com.codeborne.selenide.Configuration.timeout;
import static com.codeborne.selenide.Configuration.startMaximized;

public class RefactoredMailTest {

    @BeforeEach
    public void openBrowser(){
        timeout = 10000;
        startMaximized = true;
        browser = "chrome";
    }

    @AfterEach
    public void closeBrowser(){
        closeBrowser();
    }
}
