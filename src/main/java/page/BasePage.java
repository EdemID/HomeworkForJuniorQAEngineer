package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;
import static utils.AllureRuntime.captureScreenshot;

public class BasePage {

    int customTimeout = 60000;

    @Step("Проверяет началичие элемента на странице: {element}")
    public boolean isCheckedElement(String element) {
        return $x("//div[text()='" + element + "']").waitUntil(Condition.visible, customTimeout).isDisplayed();
    }

    @Step("Выходит из главной страницы")
    public <T extends BasePage> T logout(Class<T> typeNextPage) {
        $x("//div[text()=' Сотрудник']").waitUntil(Condition.visible, customTimeout).click();
        captureScreenshot();
        $x("//span[text()='Выйти']").waitUntil(Condition.visible, customTimeout).click();
        return typeNextPage.cast(Selenide.page(typeNextPage));
    }
}
