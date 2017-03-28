package chromedriver;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AdminPanelTest {

    WebDriver driver = new ChromeDriver();
    LoginPage loginPage = new LoginPage(driver);
    KokpitPage kokpitPage = new KokpitPage(driver);
    AdminPanelPage adminPanelPage = new AdminPanelPage(driver);

    @BeforeMethod
    public void setUp() {
        loginPage.openPage();
        loginPage.logInAsAdmin("administrator@testarena.pl", "sumXQQ72$L");

    }

    @Test
    public void shouldAddNewProject() {
        kokpitPage.goToAdminPanel();
        adminPanelPage
                .clickAddProjectButton()
                .setProjectName("Proj0")
                .setProjectPrefix("qv0")
//        adminPanelPage.setColorOfOpenStatusProject();
                .setProjectDescription("T")
                .clickSaveProjectButton();

        Assert.assertTrue(adminPanelPage.findNotificationAddedNewProject());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
