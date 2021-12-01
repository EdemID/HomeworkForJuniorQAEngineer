package utils;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;

public class CustomAlert {

    @Step("Получает текст всплывающего окна")
    public static String getAlertText() {
        return Selenide.switchTo().alert().getText();
    }
}
