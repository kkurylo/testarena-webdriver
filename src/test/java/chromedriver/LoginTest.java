package chromedriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {

    WebDriver driver = new ChromeDriver();
    LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

    @BeforeMethod
    public void setUp() {
        loginPage.openPage();
    }

    @Test
    public void shouldLoginSuccessfully() {
        loginPage.logInAsAdmin("administrator@testarena.pl", "sumXQQ72$L");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
