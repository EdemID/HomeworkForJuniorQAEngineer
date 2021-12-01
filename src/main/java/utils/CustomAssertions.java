package utils;

import io.qameta.allure.Step;

public class CustomAssertions {

    @Step("Проверяет отсутсвие ошибки: {message}")
    public static void assertTrue(boolean check, String message) {
        org.junit.jupiter.api.Assertions.assertTrue(check, message);
    }

    @Step("Проверяет отсутсвие ошибки: {message}")
    public static void assertEquals(Object expected, Object actual, String message) {
        org.junit.jupiter.api.Assertions.assertEquals(expected, actual, message);
    }
}
