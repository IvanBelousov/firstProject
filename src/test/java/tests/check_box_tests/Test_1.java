package tests.check_box_tests;

import browser.Browser;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.demoqa.elements.CheckBoxPage;
import pages.demoqa.elements.ElementsPage;
import pages.demoqa.main_pages.MainPage;

//Test_1
public class Test_1 {
    private WebDriver driver;
    private MainPage mainPage;
    private ElementsPage elementsPage;
    private CheckBoxPage checkBoxPage;

    @BeforeClass
    public void beforeClass() {
        driver = Browser.createDriver();
        mainPage = new MainPage(driver);
        mainPage.openStartPage();
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    @Test
    public void step_01() {
        elementsPage = mainPage.openCategoryElements();
        checkBoxPage = elementsPage.openCheckBox();
        checkBoxPage.verifyHeaderMainTextDisplay(ElementsPage.CHECK_BOX);;
    }

    @Test
    public void step_02() {
        checkBoxPage.setCheckBoxHome(true);
        Assert.assertTrue(checkBoxPage.getCheckBoxState("Home"));
        checkBoxPage.getText("//div[@id='result']");
        checkBoxPage.verifyTextResultIfCheckBoxHomeEnable();
    }
}
