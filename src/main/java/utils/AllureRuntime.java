package utils;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Attachment;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AllureRuntime {

    @Attachment(value = "Screenshot", type = "image/jpg")
    public static byte[] captureScreenshot(){
        String name = "screen_"+ Utilities.generatesRandomString();
        String screenshot = Selenide.screenshot(name);
        try {
            return Files.readAllBytes(Paths.get(screenshot));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new byte[0];
    }
}
