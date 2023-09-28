package pages.demoqa.book_store_application;

import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

public class BookStoreApplicationPage extends BasePage {
    public BookStoreApplicationPage(WebDriver driver) {
        super(driver);
    }
    public static final String HEADER_TEXT = "Book Store";
}
