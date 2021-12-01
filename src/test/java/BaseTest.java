import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import config.Properties;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseTest {
    private static final Logger LOG = LoggerFactory.getLogger(BaseTest.class);
    static Properties props = ConfigFactory.create(Properties.class);
    private static DesiredCapabilities capabilities = new DesiredCapabilities();
    private static ChromeOptions chromeOptions = new ChromeOptions();

    @BeforeAll
    private static void setup() {
        LOG.info("Тест стартует!");
        chromeOptions.addArguments("--lang=ru-ru");
        chromeOptions.addArguments("chrome.switches", "--disable-extensions");
        capabilities.setBrowserName("chrome");
        capabilities.setBrowserName("96.0");
        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        Configuration.baseUrl = props.mirapolisurl();
        Configuration.startMaximized = true;
        Configuration.timeout = 15000;
        Configuration.screenshots = true;
    }

    @AfterEach
    private void afterTest() {
        LOG.info("Тест завершен!");
        Selenide.closeWebDriver();
    }
}
