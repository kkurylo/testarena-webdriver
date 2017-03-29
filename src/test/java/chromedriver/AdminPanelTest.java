package chromedriver;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AdminPanelTest extends MainTest {

    private KokpitPage kokpitPage = new KokpitPage(driver);
    private AdminPanelPage adminPanelPage = new AdminPanelPage(driver);

    @BeforeMethod
    public void setUp() {
        loginPage.openPage();
        loginPage.logInAsAdmin(properties.getProperty("adminEmail"), properties.getProperty("adminPassword"));

    }

    @Test
    public void shouldAddNewProject() {
        kokpitPage.goToAdminPanel();
        adminPanelPage
                .clickAddProjectButton()
                .setProjectName(properties.getProperty("projectName1"))
                .setProjectPrefix(properties.getProperty("projectPrefix1"))
                .setColorForOpenStatus(properties.getProperty("colorForOpenStatus1"))
                .setColorForInProgressStatus(properties.getProperty("colorForInProgressStatus1"))
                .setProjectDescription(properties.getProperty("projectDescription1"))
                .clickSaveProjectButton();

        org.testng.Assert.assertTrue(adminPanelPage.tellIfNotificationBoxAddedNewProjectIsFounded());
    }
}
