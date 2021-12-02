import com.codeborne.selenide.junit5.ScreenShooterExtension;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import page.LoginPage;
import page.MainMirapolisPage;
import page.PasswordRecoveryPage;
import utils.CustomAssertions;

import static utils.CustomAlert.getAlertText;
import static utils.Utilities.open;

@ExtendWith({ScreenShooterExtension.class})
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Tests extends BaseTest {

    @Order(1)
    @ParameterizedTest(name = "{displayName} [{arguments}]")
    @DisplayName("Вход с верными логином и паролем")
    @MethodSource("utils.Data#loginTestWithLoginAndPassword")
    void loginTestWithLoginAndPassword(String login, String password) {
        LoginPage loginPage = open("/mira", LoginPage.class);
        MainMirapolisPage mainMirapolisPage = loginPage.login(login, password);
        CustomAssertions.assertTrue(mainMirapolisPage.isCheckedElement("База знаний"), "Неудачный вход в систему");
        mainMirapolisPage.logout(LoginPage.class);
    }

    @Order(2)
    @ParameterizedTest(name = "{displayName} [{arguments}]")
    @DisplayName("Вход с неверными логином и паролем")
    @MethodSource("utils.Data#loginTestWithIncorrectData")
    void loginTestWithIncorrectData(String login, String password, String expectedMessage) {
        LoginPage loginPage = open("/mira", LoginPage.class);
        loginPage.login(login, password);
        CustomAssertions.assertEquals(expectedMessage, getAlertText(),"Успешный вход в систему");
    }

    @Order(3)
    @ParameterizedTest(name = "{displayName} [{arguments}]")
    @DisplayName("Вход с неверными логином и паролем")
    @MethodSource("utils.Data#showPassword")
    void showPassword(String password) {
        LoginPage loginPage = open("/mira", LoginPage.class);
        CustomAssertions.assertTrue(loginPage.isShowPassword(password),"Пароль не показан");
    }

    @Test
    void forgotPassword() {
        LoginPage loginPage = open("/mira", LoginPage.class);
        PasswordRecoveryPage passwordRecoveryPage = loginPage.goesToThePasswordRecoveryPage(PasswordRecoveryPage.class);
        CustomAssertions.assertTrue(passwordRecoveryPage.isCheckedElement("Восстановление пароля"), "Ссылка не работает");
    }
}
