package page;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;
import static utils.AllureRuntime.captureScreenshot;

public class LoginPage {

    SelenideElement loginElememt = $x("//input[@placeholder='Введите ваш логин']");
    SelenideElement passwordElement = $x("//input[@placeholder='Введите ваш пароль']");
    SelenideElement buttonLoginElement = $x("//button[text()='Войти']");

    @Step("Входит под пользователем: {username} с паролем {password}")
    public MainMirapolisPage login(String username, String password) {
        loginElememt.setValue(username);
        passwordElement.setValue(password);
        captureScreenshot();
        buttonLoginElement.click();
        return Selenide.page(MainMirapolisPage.class);
    }
}
