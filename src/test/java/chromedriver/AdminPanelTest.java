package chromedriver;

import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AdminPanelTest extends MainTest {

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
                .setProjectDescription("T")
                .clickSaveProjectButton();

        Assert.assertTrue(adminPanelPage.findNotificationAddedNewProject());
    }

}
