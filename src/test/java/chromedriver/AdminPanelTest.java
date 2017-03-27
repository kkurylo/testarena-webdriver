package chromedriver;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AdminPanelTest {

    WebDriver driver = new ChromeDriver();
    LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
    KokpitPage kokpitPage = PageFactory.initElements(driver, KokpitPage.class);
    AdminPanelPage adminPanelPage = PageFactory.initElements(driver, AdminPanelPage.class);

    @BeforeMethod
    public void setUp() {
        loginPage.openPage();
        loginPage.logInAsAdmin("administrator@testarena.pl", "sumXQQ72$L");

    }

    @Test
    public void shouldAddNewProject() {
        kokpitPage.goToAdminPanel();
        adminPanelPage.clickAddProjectButton();
        adminPanelPage.setProjectName("Project122");
        adminPanelPage.setProjectPrefix("22");
        adminPanelPage.setProjectDescription("This is the best project ever");
        adminPanelPage.clickSaveProjectButton();

        Assert.assertTrue(adminPanelPage.findNotificationAddedNewProject());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
