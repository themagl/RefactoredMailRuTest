package ru.vereshchagin.components;

import com.codeborne.selenide.ElementsContainer;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class NavigateMenuBlock extends ElementsContainer {
    private SelenideElement inbox = $x("//span[text()='Входящие']");
    private SelenideElement sent = $x("//span[text()='Отправленные']");
    private SelenideElement drafts = $x("//span[text()='Черновики']");
    private SelenideElement garbage = $x("//span[text()='Корзина']");
    private SelenideElement folderSettingsButton = $x("//span[text()='Настроить папки']");

    public void goToInbox() {
        inbox.click();
    }

    public void goToSent() {
        sent.click();
    }

    public void goToDrafts() {
        drafts.click();
    }

    public void goToGarbage() {
        garbage.click();
    }

    public void foldersSettingsClick() {
        $x(String.format("%s/parent::a/parent::div", folderSettingsButton)).hover();

        folderSettingsButton.click();
    }

}
