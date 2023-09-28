package tests.text_box_tests;

import browser.Browser;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.demoqa.elements.ElementsPage;
import pages.demoqa.elements.TextBoxPage;
import pages.demoqa.main_pages.MainPage;

public class Test_1 {
    private WebDriver driver;
    private MainPage mainPage;
    private ElementsPage elementsPage;
    private TextBoxPage textBoxPage;

    private String fullName = "Belousov Ivan";
    private String email = "test@test.ru";
    private String curAddr = "Курск";
    private String permAddr = "Курчатов";

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
        textBoxPage = elementsPage.openTextBox();
        textBoxPage.verifyHeaderMainTextDisplay(ElementsPage.TEXT_BOX);;
    }

    @Test
    public void step_02() {
        textBoxPage.setFullName(fullName);
        textBoxPage.setEmail(email);
        textBoxPage.setCurrentAddress(curAddr);
        textBoxPage.setPermanentAddress(permAddr);
        textBoxPage.clickSubmit();
        //textBoxPage.setAllFieldAndSubmit(fullName,email,curAddr,permAddr); можно использовать этот метод вместо 5 предыдущих строк
        Assert.assertEquals(textBoxPage.getOutputName(), "Name:" + fullName);// Вытаскивает значение из поля вывода и сравнивает с нашей переменной
        textBoxPage.verifyOutputName(fullName);// делает тоже самое что и предыдущая строчка
        Assert.assertEquals(textBoxPage.getOutputEmail(), "Email:" + email);
        textBoxPage.verifyOutputEmail(email);
        Assert.assertEquals(textBoxPage.getOutputCurAddr(), "Current Address :" + curAddr);
        textBoxPage.verifyOutputCurAddr(curAddr);
        Assert.assertEquals(textBoxPage.getOutputPermAddr(), "Permananet Address :" + permAddr);
        textBoxPage.verifyOutputPermAddr(permAddr);
    }

}
