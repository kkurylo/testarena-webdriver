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
        loginPage.logInAsAdmin("administrator@testarena.pl", "sumXQQ72$L");
    }

}
