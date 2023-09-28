package pages.demoqa.elements;

import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

import static pages.demoqa.main_pages.MainPage.ELEMENTS_CATEGORY_CARDS;

public class ElementsPage extends BasePage {
    public ElementsPage(WebDriver driver) {
        super(driver);
    }

    public static final String URL = "https://demoqa.com/elements";
    public static final String TEXT_BOX = "Text Box";
    public static final String CHECK_BOX = "Check Box";
    public static final String RADIO_BUTTON = "Radio Button";
    public static final String WEB_TABLES = "Web Tables";
    public static final String BUTTONS = "Buttons";
    public static final String LINKS = "Links";
    public static final String BROKEN_LINKS_IMAGES = "Broken Links - Images";
    public static final String UPLOAD_AND_DOWNLOAD = "Upload and Download";
    public static final String DYNAMIC_PROPERTIES = "Dynamic Properties";


    public void openItemInElementsBlock(String item) {
        clickMenuItem(ELEMENTS_CATEGORY_CARDS, item);
    }

    public TextBoxPage openTextBox() {
        openItemInElementsBlock(TEXT_BOX);
        return new TextBoxPage(driver);
    }

    public CheckBoxPage openCheckBox() {
        openItemInElementsBlock(CHECK_BOX);
        return new CheckBoxPage(driver);
    }

    public DynamicPropertiesPage openDynamicProperties() {
        openItemInElementsBlock(DYNAMIC_PROPERTIES);
        return new DynamicPropertiesPage(driver);
    }

    public BrokenLinksImagesPage openBrokenLinksImagesPage() {
        openItemInElementsBlock(BROKEN_LINKS_IMAGES);
        return new BrokenLinksImagesPage(driver);
    }

    public ButtonsPage openButtonsPage() {
        openItemInElementsBlock(BUTTONS);
        return new ButtonsPage(driver);
    }

    public LinksPage openLinksPage() {
        openItemInElementsBlock(LINKS);
        return new LinksPage(driver);
    }

    public RadioButtonPage openRadioButtonPage() {
        openItemInElementsBlock(RADIO_BUTTON);
        return new RadioButtonPage(driver);
    }

    public UploadAndDownloadPage openUploadAndDownloadPage() {
        openItemInElementsBlock(UPLOAD_AND_DOWNLOAD);
        return new UploadAndDownloadPage(driver);
    }

    public WebTablesPage openWebTablesPage() {
        openItemInElementsBlock(WEB_TABLES);
        return new WebTablesPage(driver);
    }


}
