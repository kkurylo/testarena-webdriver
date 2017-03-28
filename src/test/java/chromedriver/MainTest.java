package chromedriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.Properties;

public class MainTest {

    WebDriver driver = new ChromeDriver();
    LoginPage loginPage = new LoginPage(driver);
    static Properties properties = new Properties();

    @BeforeClass
    public static void before() throws IOException {
        properties.load(MainTest.class.getClassLoader().getResourceAsStream("test.properties"));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
