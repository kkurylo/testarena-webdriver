package chromedriver;

import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProjectsTest extends MainTest {

    KokpitPage kokpitPage = new KokpitPage(driver);
    AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
    ProjectsPage projectsPage = new ProjectsPage(driver);

    @BeforeMethod
    public void setUp() {
        loginPage.openPage();
        loginPage.logInAsAdmin("administrator@testarena.pl", "sumXQQ72$L");
        kokpitPage.goToAdminPanel();
        adminPanelPage
                .clickAddProjectButton()
                .setProjectName("mojnowyprojekt0")
                .setProjectPrefix("22a0")
                .setProjectDescription("niema")
                .clickSaveProjectButton();
    }

    @Test
    public void shouldFindMyProject() {
        projectsPage
                .goToProjectsSection()
                .setSearchingProject("mojnowyprojekt0")
                .searchProject();

        Assert.assertTrue(projectsPage.tellIfProjectIsFounded());
    }

}
