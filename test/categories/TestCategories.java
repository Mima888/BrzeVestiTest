package categories;

import framework.Configuration;
import java.io.IOException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import pages.CategoriesPage;
import pages.DashboardPage;
import pages.LoginPage;

public class TestCategories {

    private static LoginPage loginPage;
    private static DashboardPage dashboardPage;
    private static CategoriesPage categoriesPage;

    @BeforeClass
    public static void setUpClass() throws IOException {
        Configuration.init();
        loginPage = new LoginPage();
        dashboardPage = loginPage.login();
    }

    @AfterClass
    public static void tearDownClass() throws InterruptedException {
//        Thread.sleep(3000);
//        loginPage.quitDriver();
    }

    @Before
    public void setUp() {
        categoriesPage = dashboardPage.goToCategories();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testCreateNewCategory() {

        categoriesPage.addNewCategory();
    }

    @Test
    public void testEditCategory() {

//        categoriesPage.editLastCategory();
        categoriesPage.editFirstCategory();
//        categoriesPage.editRandomCategory();
    }

    @Test
    public void testDeleteCategory() {
        categoriesPage.deleteFirstCategory();
//        categoriesPage.deleteLastCategory();
//        categoriesPage.deleteRandomCategory();
    }

    @Test
    public void disableCategory() {

//        categoriesPage.disableFirstCategory();
//       categoriesPage.disableLastCategory();
//       categoriesPage.disableRandomCategory();
    }

    @Test
    public void enableCategory() {

//        categoriesPage.enableFirstCategory();
//        categoriesPage.enableLastCategory();
    }
}
