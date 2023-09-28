package pages.demoqa.main_pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.base.BasePage;
import pages.demoqa.alerts_frame_windows.AlertsFramsWindowsPage;
import pages.demoqa.book_store_application.BookStoreApplicationPage;
import pages.demoqa.elements.ElementsPage;
import pages.demoqa.forms.FormPage;
import pages.demoqa.interactions.InteractionsPage;
import pages.demoqa.widgets.WidgetsPage;

import static constants.Constant.URLS.START_PAGE_URL;

public class MainPage extends BasePage {
    public MainPage(WebDriver driver) {
        super(driver);
    }

    public static final String HOME_BANNER = "//div[@class='home-banner'][a[@href='https://www.toolsqa.com/selenium-training/'][img[contains(@src,'WB.svg')]]]";
    public static final String CATEGORY_XPATH = "//div[contains(@class, 'card mt-4 ')]";
    public static final String CATEGORY_CARDS_XPATH_HARD = CATEGORY_XPATH + "[div//h5[text()='%s']]";
    public static final String CATEGORY_CARDS_XPATH_LOW = CATEGORY_XPATH + "[div//h5[contains(text(),'%s')]]";
    public static final String ELEMENTS_CATEGORY_CARDS = "Elements";
    public static final String FORMS_CATEGORY_CARDS = "Forms";
    public static final String ALERTS_FRAME_WINDOWS_CATEGORY_CARDS = "Alerts, Frame & Windows";
    public static final String WIDGETS_CATEGORY_CARDS = "Widgets";
    public static final String INTERACTIONS_CATEGORY_CARDS = "Interactions";
    public static final String BOOK_STORE_APPLICATION_CATEGORY_CARDS = "Book Store Application";

    public void openStartPage(){
        openUrl(START_PAGE_URL);
        Assert.assertTrue(isHeaderDisplayed());
        Assert.assertTrue(isElementDisplay(HOME_BANNER));
        Assert.assertTrue(isElementDisplay(getCategoryCardsLocator(ELEMENTS_CATEGORY_CARDS)));
        Assert.assertTrue(isElementDisplay(getCategoryCardsLocator(FORMS_CATEGORY_CARDS)));
        Assert.assertTrue(isElementDisplay(getCategoryCardsLocator(ALERTS_FRAME_WINDOWS_CATEGORY_CARDS)));
        Assert.assertTrue(isElementDisplay(getCategoryCardsLocator(WIDGETS_CATEGORY_CARDS)));
        Assert.assertTrue(isElementDisplay(getCategoryCardsLocator(INTERACTIONS_CATEGORY_CARDS)));
        Assert.assertTrue(isElementDisplay(getCategoryCardsLocator(BOOK_STORE_APPLICATION_CATEGORY_CARDS)));
        Assert.assertEquals(getCategoryCardsCount(),6);
    }

    public String getCategoryCardsLocator(String nameCards){
        return String.format(CATEGORY_CARDS_XPATH_HARD,nameCards);
    }

    public int getCategoryCardsCount(){
        String locator = String.format(CATEGORY_CARDS_XPATH_LOW,"");
        return getElementsCount(locator);
    }

    public void openCategoryCards(String nameCards){
        click(getCategoryCardsLocator(nameCards));
    }

    public AlertsFramsWindowsPage openCategoryAlertsFramsWindows(){
        openCategoryCards(ALERTS_FRAME_WINDOWS_CATEGORY_CARDS);
        return new AlertsFramsWindowsPage(driver);
    }

    public BookStoreApplicationPage openCategoryBookStoreApplication(){
        openCategoryCards(BOOK_STORE_APPLICATION_CATEGORY_CARDS);
        return new BookStoreApplicationPage(driver);
    }

    public ElementsPage openCategoryElements(){
        openCategoryCards(ELEMENTS_CATEGORY_CARDS);
        return new ElementsPage(driver);
    }

    public FormPage openCategoryForms(){
        openCategoryCards(FORMS_CATEGORY_CARDS);
        return new FormPage(driver);
    }

    public InteractionsPage openCategoryInteractions(){
        openCategoryCards(INTERACTIONS_CATEGORY_CARDS);
        return new InteractionsPage(driver);
    }

    public WidgetsPage openCategoryWidgets(){
        openCategoryCards(WIDGETS_CATEGORY_CARDS);
        return new WidgetsPage(driver);
    }

}
