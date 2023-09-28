package pages.demoqa.elements;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.base.BasePage;

public class TextBoxPage extends BasePage {
    public TextBoxPage(WebDriver driver) {
        super(driver);
    }

    public static final String INPUT_XPATH = "//*[@placeholder='%s']";
    public static final String PERMANENT_ADDRESS = "//textarea[@id='permanentAddress']";
    public static final String SUBMIT = "//button[@id='submit']";
    public static final String OUTPUT_XPATH = "//div[@id='output']//p[@id='%s']";

    public static final String FULL_NAME = "Full Name";
    public static final String EMAIL = "name@example.com";
    public static final String CURRENT_ADDRESS = "Current Address";


    public void setFullName(String text) {
        String locator = String.format(INPUT_XPATH, FULL_NAME);
        sendKeys(locator, text);
    }

    public void setEmail(String email) {
        String locator = String.format(INPUT_XPATH, EMAIL);
        sendKeys(locator, email);
    }

    public void setCurrentAddress(String address) {
        String locator = String.format(INPUT_XPATH, CURRENT_ADDRESS);
        sendKeys(locator, address);
    }

    public void setPermanentAddress(String address) {
        sendKeys(PERMANENT_ADDRESS, address);
    }

    public void setAllFieldAndSubmit(String fullName, String email, String curAddr, String permAddr) {
        setFullName(fullName);
        setEmail(email);
        setCurrentAddress(curAddr);
        setPermanentAddress(permAddr);
        clickSubmit();
    }

    public void clickSubmit() {
        click(SUBMIT);
    }

    public String getOutputName() {
        return getText(String.format(OUTPUT_XPATH, "name"));
    }

    public String getOutputEmail() {
        return getText(String.format(OUTPUT_XPATH, "email"));
    }

    public String getOutputCurAddr() {
        return getText(String.format(OUTPUT_XPATH, "currentAddress"));
    }

    public String getOutputPermAddr() {
        return getText(String.format(OUTPUT_XPATH, "permanentAddress"));
    }

    public void verifyOutputName(String fullName) {
        Assert.assertEquals(getOutputName(), "Name:" + fullName);
    }

    public void verifyOutputEmail(String email) {
        Assert.assertEquals(getOutputEmail(), "Email:" + email);
    }

    public void verifyOutputCurAddr(String curAddr) {
        Assert.assertEquals(getOutputCurAddr(), "Current Address :" + curAddr);
    }

    public void verifyOutputPermAddr(String permAddr) {
        Assert.assertEquals(getOutputPermAddr(), "Permananet Address :" + permAddr);
    }

}
