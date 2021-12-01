package utils;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;

import java.util.Random;

public class Utilities {

    @Step("Переходит по ссылке: {url}")
    public static <T> T open(String url, Class<T> typePage) {
        return typePage.cast(Selenide.open(url, typePage));
    }

    @Step("Генерирует рандомную строку")
    public static String generatesRandomString() {
        int length = 16;
        Random r = new Random();
        return r.ints(48, 122)
                .filter(i -> (i < 57 || i > 65) && (i < 90 || i > 97))
                .mapToObj(i -> (char) i)
                .limit(length)
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
    }
}
