package ru.vereshchagin.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class FolderSettingsPage extends BasePage<FolderSettingsPage> {

    private SelenideElement addFolderButton;
    private SelenideElement popupNewFolderName;
    private SelenideElement popupNewFolderAddButton;
    private SelenideElement newFolder;
    private SelenideElement popupDeleteFolderConfirm;

    @Step("Создаем новую папку с именем {folderName}")
    public void createNewFolder(String folderName){
        addFolderButton.hover();
        addFolderButton.click();
        popupNewFolderName.sendKeys(folderName);
        popupNewFolderAddButton.click();
    }

    @Step("Находим по названию папку {folderName}, наводим на нее мышь и жмем удалить.")
    public void hoverAndDeleteFolder(String folderName){
        $x(String.format("//div[text()='%s']", folderName)).hover().$x("/preceding-sibling::div/following-sibling::div//i/following::i").click();
    }



}
