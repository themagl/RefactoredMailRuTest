package ru.vereshchagin.components;

import com.codeborne.selenide.ElementsContainer;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ActionBar extends ElementsContainer {

    private SelenideElement deleteButton = $x("//span[starts-with(@class,'b-toolbar') and text()='Удалить']");
    private SelenideElement replaceToFolderMenu = $x("");

    public void deleteButtonClick(){
        deleteButton.click();
    }
}
