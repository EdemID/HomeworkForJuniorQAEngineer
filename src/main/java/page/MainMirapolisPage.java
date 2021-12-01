package page;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class MainMirapolisPage {

    int customTimeout = 60000;

    @Step("Проверяет началичие элемента на странице: {element}")
    public boolean isCheckedElement(String element) {
        return $x("//div[text()='" + element + "']").waitUntil(Condition.visible, customTimeout).isDisplayed();
    }
}
