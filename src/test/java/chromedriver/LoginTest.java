package chromedriver;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends MainTest {

    @BeforeMethod
    public void setUp() {
        loginPage.openPage();
    }

    @Test
    public void shouldLoginSuccessfully() {
        loginPage.logInAsAdmin(properties.getProperty("adminEmail"), properties.getProperty("adminPassword"));

        org.testng.Assert.assertTrue(loginPage.tellIfICanLogOut());
    }
}
