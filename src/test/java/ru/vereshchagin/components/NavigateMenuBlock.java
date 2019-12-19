package ru.vereshchagin.components;

import com.codeborne.selenide.ElementsContainer;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class NavigateMenuBlock extends ElementsContainer {
    private SelenideElement inbox = $x("//span[text()='Входящие']");
    private SelenideElement sent = $x("//span[text()='Отправленные']");
    private SelenideElement drafts = $x("//span[text()='Черновики']");
    private SelenideElement garbage = $x("//span[text()='Корзина']");

}
