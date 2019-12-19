package ru.vereshchagin.data;

import java.util.Date;

public class TestData {
    public static String userLogin = "theselenidetest@mail.ru";
    public static String userPassword = "Autotest1";
    public static String messageSubject = "Это тестовое письмо";
    public static String messageText = new Date().toString();

    // Переменная Число Пи для проверки содержания письма
    public static String piCheck = Double.toString(Math.PI);

    public static String folderName = "NewTestFolder";
}
