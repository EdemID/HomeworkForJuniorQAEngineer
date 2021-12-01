import com.codeborne.selenide.junit5.ScreenShooterExtension;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import page.LoginPage;
import page.MainMirapolisPage;
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
    }

    @Order(2)
    @ParameterizedTest(name = "{displayName} [{arguments}]")
    @DisplayName("Вход с верным логином")
    @MethodSource("utils.Data#loginTestWithLogin")
    void loginTestWithLogin(String login, String password) {
        LoginPage loginPage = open("/mira", LoginPage.class);
        loginPage.login(login, password);
        CustomAssertions.assertEquals("Неверные данные для авторизации", getAlertText(),"Успешный вход в систему");
    }

    @Order(3)
    @ParameterizedTest(name = "{displayName} [{arguments}]")
    @DisplayName("Вход с верным паролем")
    @MethodSource("utils.Data#loginTestWithPassword")
    void loginTestWithPassword(String login, String password) {
        LoginPage loginPage = open("/mira", LoginPage.class);
        loginPage.login(login, password);
        CustomAssertions.assertEquals("Неверные данные для авторизации", getAlertText(),"Успешный вход в систему");
    }

    @Order(4)
    @ParameterizedTest(name = "{displayName} [{arguments}]")
    @DisplayName("Вход с неверными логином и паролем")
    @MethodSource("utils.Data#loginTestWithIncorrectData")
    void loginTestWithIncorrectData(String login, String password) {
        LoginPage loginPage = open("/mira", LoginPage.class);
        loginPage.login(login, password);
        CustomAssertions.assertEquals("Неверные данные для авторизации", getAlertText(),"Успешный вход в систему");
    }

    @Order(5)
    @ParameterizedTest(name = "{displayName} [{arguments}]")
    @DisplayName("Вход без логина и пароля")
    @MethodSource("utils.Data#loginTestWithoutLoginAndPassword")
    void loginTestWithoutLoginAndPassword(String login, String password) {
        LoginPage loginPage = open("/mira", LoginPage.class);
        loginPage.login(login, password);
        CustomAssertions.assertEquals("Неверные данные для авторизации.", getAlertText(),"Успешный вход в систему");
    }

    @Order(6)
    @ParameterizedTest(name = "{displayName} [{arguments}]")
    @DisplayName("Вход с верным логином и без пароля")
    @MethodSource("utils.Data#loginTestWithLoginAndWithoutPassword")
    void loginTestWithLoginAndWithoutPassword(String login, String password) {
        LoginPage loginPage = open("/mira", LoginPage.class);
        loginPage.login(login, password);
        CustomAssertions.assertEquals("Неверные данные для авторизации.", getAlertText(),"Успешный вход в систему");
    }

    @Order(7)
    @ParameterizedTest(name = "{displayName} [{arguments}]")
    @DisplayName("Вход с верным паролем без логина")
    @MethodSource("utils.Data#loginTestWithPasswordAndWithoutLogin")
    void loginTestWithPasswordAndWithoutLogin(String login, String password) {
        LoginPage loginPage = open("/mira", LoginPage.class);
        loginPage.login(login, password);
        CustomAssertions.assertEquals("Неверные данные для авторизации.", getAlertText(),"Успешный вход в систему");
    }
}
