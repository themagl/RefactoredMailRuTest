package ru.vereshchagin.pages;

public class BasePage<T extends BasePage> {

    public T returnMethod(){
        return (T) this;
    }
}
