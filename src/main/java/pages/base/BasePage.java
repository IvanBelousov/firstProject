package pages.base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

import static constants.Constant.TimeoutVariable.EXPLICIT_WAIT;


public class BasePage {
    protected WebDriver driver;
    public static final String HEADER_XPATH = "//header/a[@href='https://demoqa.com'][img[@src='/images/Toolsqa.jpg']]";
    public static final String MAIN_HEADER = "//div[@class='main-header']";
    public static final String BLOCK_MENU_XPATH = "//div[@class='header-text' and contains(text(),'%s')]/ancestor::span";
    public static final String ITEM_MENU_XPATH = "//span[contains(text(),'%s')]";
    public static final String CHECK_BOX_XPATH = "//input[@type='checkbox'][following-sibling::span[contains(text(),'%s')]]";

    public BasePage(WebDriver driver) { //конструктор класса
        this.driver = driver;
    }

    public void openUrl(String url) {
        driver.get(url);
    }

    public WebElement findElement(String locator) {
        WebElement element = driver.findElement(By.xpath(locator));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
        return element;
    }

    public List<WebElement> findElements(String locator) {
        return driver.findElements(By.xpath(locator));
    }


    public void waitElementIsVisible(String locator, int second) {
        new WebDriverWait(driver, Duration.ofSeconds(second)).until(ExpectedConditions.visibilityOf(findElement(locator)));
    }

    public void waitElementIsVisible(String locator) {
        waitElementIsVisible(locator, EXPLICIT_WAIT);
    }

    public void click(String locator) {
        findElement(locator).click();
    }

    public void clear(String locator) {
        findElement(locator).clear();
    }

    public void sendKeys(String locator, String text) {
        findElement(locator).sendKeys(text);
    }

    public void sendKeysWithClear(String locator, String text){
        clear(locator);
        sendKeys(locator,text);
    }

    public String getText(String locator) {
        return findElement(locator).getText();
    }

    protected boolean isElementDisplay(String locator) {
        try {
            return findElement(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isHeaderDisplayed() {
        return isElementDisplay(HEADER_XPATH);
    }

    public int getElementsCount(String locator) {
        return findElements(locator).size();
    }

    public boolean isHeaderMainTextDisplay(String text) {
        if (getText(MAIN_HEADER).equals(text))
            return true;
        else
            return false;

    }

    public void verifyHeaderMainTextDisplay(String text){
        Assert.assertTrue(isHeaderMainTextDisplay(text));
    }

    public void scrollPageToElement(String locator){
        WebElement element = findElement(locator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public void clickMenuItem(String blockName, String item){
        String blockMenuLocator = String.format(BLOCK_MENU_XPATH,blockName);
        String blockMenuActiveLocator = blockMenuLocator + "/following-sibling::div[contains(@class,'show')]";
        String itemMenuLocator = blockMenuActiveLocator + String.format(ITEM_MENU_XPATH,item);
        if(!isElementDisplay(blockMenuActiveLocator)){
            click(blockMenuLocator);
        }
        click(itemMenuLocator);
    }

    public boolean getCheckBoxState(String checkBoxName){
        String locator = String.format(CHECK_BOX_XPATH, checkBoxName);
        return findElement(locator).isSelected();
    }

    /**
     * Переводит чек-бокс в нужное состочние
     * @param checkBoxName - Название чек-бокса
     * @param state - нужное состочние, true если чек-бокс должен быть активным, false - если нет
     */
    public void setCheckBox(String checkBoxName, boolean state){
        String locator = String.format(CHECK_BOX_XPATH, checkBoxName) + "/following-sibling::span[@class='rct-checkbox']";
        if (!getCheckBoxState(checkBoxName)==state){
            click(locator);
        }
    }


}
