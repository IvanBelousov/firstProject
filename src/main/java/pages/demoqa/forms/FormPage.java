package pages.demoqa.forms;

import org.openqa.selenium.WebDriver;
import pages.base.BasePage;
import pages.demoqa.elements.TextBoxPage;
import pages.demoqa.main_pages.MainPage;

public class FormPage extends BasePage {
    public FormPage(WebDriver driver) {
        super(driver);
    }
    public static final String PRACTICE_FORM = "Practice Form";

    public void openItemInElementsBlock(String item) {
        clickMenuItem(MainPage.FORMS_CATEGORY_CARDS, item);
    }

    public PracticeFormPage openPracticalForm() {
        openItemInElementsBlock(PRACTICE_FORM);
        return new PracticeFormPage(driver);
    }
}
