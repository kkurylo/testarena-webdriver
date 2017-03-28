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
                .setProjectName("Proj19")
                .setProjectPrefix("qvi19")
                .setColorForOpenStatus("#f4cccc")
                .setColorForInProgressStatus("#b6d7a8")
                .setProjectDescription("T")
                .clickSaveProjectButton();

        Assert.assertTrue(adminPanelPage.findNotificationAddedNewProject());
    }

}
