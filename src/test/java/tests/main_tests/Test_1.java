package tests.main_tests;

import browser.Browser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.demoqa.alerts_frame_windows.AlertsFramsWindowsPage;
import pages.demoqa.book_store_application.BookStoreApplicationPage;
import pages.demoqa.elements.*;
import pages.demoqa.forms.FormPage;
import pages.demoqa.forms.PracticeFormPage;
import pages.demoqa.interactions.InteractionsPage;
import pages.demoqa.main_pages.MainPage;
import pages.demoqa.widgets.WidgetsPage;

public class Test_1 {
    private WebDriver driver;
    private MainPage mainPage;
    private ElementsPage elementsPage;
    private BrokenLinksImagesPage brokenLinksImagesPage;
    private ButtonsPage buttonsPage;
    private CheckBoxPage checkBoxPage;
    private DynamicPropertiesPage dynamicPropertiesPage;
    private LinksPage linksPage;
    private RadioButtonPage radioButtonPage;
    private TextBoxPage textBoxPage;
    private UploadAndDownloadPage uploadAndDownloadPage;
    private WebTablesPage webTablesPage;
    private FormPage formPage;
    private PracticeFormPage practiceFormPage;
    private AlertsFramsWindowsPage alertsFramsWindowsPage;
    private BookStoreApplicationPage bookStoreApplicationPage;
    private InteractionsPage interactionsPage;
    private WidgetsPage widgetsPage;

    @BeforeClass
    public void beforeClass(){
        driver = Browser.createDriver();
        elementsPage = new ElementsPage(driver);
        alertsFramsWindowsPage = new AlertsFramsWindowsPage(driver);
        bookStoreApplicationPage = new BookStoreApplicationPage(driver);
        formPage = new FormPage(driver);
        interactionsPage = new InteractionsPage(driver);
        mainPage = new MainPage(driver);
        widgetsPage = new WidgetsPage(driver);
        mainPage.openStartPage(); //Метод открытия главной страницы, проверки внутри метода
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }

    @Test
    public void step_01(){
        mainPage.openCategoryCards(MainPage.ELEMENTS_CATEGORY_CARDS);
        elementsPage.verifyHeaderMainTextDisplay(MainPage.ELEMENTS_CATEGORY_CARDS);
    }

    @Test
    public void step_02(){
        textBoxPage = elementsPage.openTextBox();
        textBoxPage.verifyHeaderMainTextDisplay(ElementsPage.TEXT_BOX);
    }

    @Test
    public void step_03(){
        checkBoxPage = elementsPage.openCheckBox();
        checkBoxPage.verifyHeaderMainTextDisplay(ElementsPage.CHECK_BOX);
    }
    @Test
    public void step_04(){
        radioButtonPage = elementsPage.openRadioButtonPage();
        radioButtonPage.verifyHeaderMainTextDisplay(ElementsPage.RADIO_BUTTON);
    }

    @Test
    public void step_05(){
        webTablesPage = elementsPage.openWebTablesPage();
        webTablesPage.verifyHeaderMainTextDisplay(ElementsPage.WEB_TABLES);
    }

    @Test
    public void step_06(){
        buttonsPage = elementsPage.openButtonsPage();
        buttonsPage.verifyHeaderMainTextDisplay(ElementsPage.BUTTONS);
    }

    @Test
    public void step_07(){
        linksPage = elementsPage.openLinksPage();
        linksPage.verifyHeaderMainTextDisplay(ElementsPage.LINKS);
    }

    @Test
    public void step_08(){
        brokenLinksImagesPage = elementsPage.openBrokenLinksImagesPage();
        brokenLinksImagesPage.verifyHeaderMainTextDisplay(ElementsPage.BROKEN_LINKS_IMAGES);
    }

    @Test
    public void step_09(){
        brokenLinksImagesPage = elementsPage.openBrokenLinksImagesPage();
        brokenLinksImagesPage.verifyHeaderMainTextDisplay(ElementsPage.BROKEN_LINKS_IMAGES);
    }

    @Test
    public void step_10(){
        uploadAndDownloadPage = elementsPage.openUploadAndDownloadPage();
        uploadAndDownloadPage.verifyHeaderMainTextDisplay(ElementsPage.UPLOAD_AND_DOWNLOAD);
    }

    @Test
    public void step_11(){
        dynamicPropertiesPage = elementsPage.openDynamicProperties();
        dynamicPropertiesPage.verifyHeaderMainTextDisplay(ElementsPage.DYNAMIC_PROPERTIES);
    }

    @Test
    public void step_12(){
        mainPage.openStartPage();
        mainPage.openCategoryCards(MainPage.FORMS_CATEGORY_CARDS);
        formPage.verifyHeaderMainTextDisplay(MainPage.FORMS_CATEGORY_CARDS);
    }
    @Test
    public void step_13(){
        practiceFormPage = formPage.openPracticalForm();
        practiceFormPage.verifyHeaderMainTextDisplay(FormPage.PRACTICE_FORM);
    }

    @Test
    public void step_14(){
        mainPage.openStartPage();
        mainPage.openCategoryCards(MainPage.ALERTS_FRAME_WINDOWS_CATEGORY_CARDS);
        alertsFramsWindowsPage.verifyHeaderMainTextDisplay(MainPage.ALERTS_FRAME_WINDOWS_CATEGORY_CARDS);
    }

    @Test
    public void step_15(){
        mainPage.openStartPage();
        mainPage.openCategoryCards(MainPage.BOOK_STORE_APPLICATION_CATEGORY_CARDS);
        bookStoreApplicationPage.verifyHeaderMainTextDisplay(BookStoreApplicationPage.HEADER_TEXT);
    }

    @Test
    public void step_16(){
        mainPage.openStartPage();
        mainPage.openCategoryCards(MainPage.INTERACTIONS_CATEGORY_CARDS);
        interactionsPage.verifyHeaderMainTextDisplay(MainPage.INTERACTIONS_CATEGORY_CARDS);
    }

    @Test
    public void step_17(){
        mainPage.openStartPage();
        mainPage.openCategoryCards(MainPage.WIDGETS_CATEGORY_CARDS);
        bookStoreApplicationPage.verifyHeaderMainTextDisplay(MainPage.WIDGETS_CATEGORY_CARDS);
    }

}
