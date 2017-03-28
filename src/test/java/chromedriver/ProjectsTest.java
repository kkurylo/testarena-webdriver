package chromedriver;

import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProjectsTest extends MainTest {

    private KokpitPage kokpitPage = new KokpitPage(driver);
    private AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
    private ProjectsPage projectsPage = new ProjectsPage(driver);

    @BeforeMethod
    public void setUp() {
        loginPage.openPage();
        loginPage.logInAsAdmin(properties.getProperty("adminEmail"), properties.getProperty("adminPassword"));
        kokpitPage.goToAdminPanel();
        adminPanelPage
                .clickAddProjectButton()
                .setProjectName(properties.getProperty("projectName2"))
                .setProjectPrefix(properties.getProperty("projectPrefix2"))
                .setColorForOpenStatus(properties.getProperty("colorForOpenStatus2"))
                .setColorForInProgressStatus(properties.getProperty("colorForInProgressStatus2"))
                .setProjectDescription(properties.getProperty("projectDescription2"))
                .clickSaveProjectButton();
    }

    @Test
    public void shouldFindMyProject() {
        projectsPage
                .goToProjectsSection()
                .setSearchingProject(properties.getProperty("projectName2"))
                .searchProject();

        Assert.assertTrue(projectsPage.tellIfProjectIsFounded());
    }
}
