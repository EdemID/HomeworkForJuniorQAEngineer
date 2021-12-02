package page;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;
import static utils.AllureRuntime.captureScreenshot;

public class LoginPage extends BasePage {

    private SelenideElement loginElememt = $x("//input[@placeholder='Введите ваш логин']");
    private SelenideElement passwordElement = $x("//input[@placeholder='Введите ваш пароль']");
    private SelenideElement buttonLoginElement = $x("//button[text()='Войти']");
    private SelenideElement buttonShowPassword = $x("//input[@type='password']/following-sibling::button");
    private SelenideElement forgotPassword = $x("//td//div[text() = 'Забыли пароль?']");

    @Step("Входит под пользователем: {username} с паролем {password}")
    public MainMirapolisPage login(String username, String password) {
        loginElememt.setValue(username);
        passwordElement.setValue(password);
        captureScreenshot();
        buttonLoginElement.click();
        return Selenide.page(MainMirapolisPage.class);
    }

    @Step("Проверяет видимость пароля")
    public boolean isShowPassword(String password) {
        passwordElement.setValue(password);
        buttonShowPassword.click();
        captureScreenshot();
        return password.equals(passwordElement.getValue());
    }

    @Step("Переходит на страницу Восстановление пароля")
    public <T extends BasePage> T goesToThePasswordRecoveryPage(Class<T> typeNextPage) {
        forgotPassword.click();
        return typeNextPage.cast(Selenide.page(typeNextPage));
    }
}
