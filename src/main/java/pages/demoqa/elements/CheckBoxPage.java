package pages.demoqa.elements;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.base.BasePage;

public class CheckBoxPage extends BasePage {
    public CheckBoxPage(WebDriver driver) {
        super(driver);
    }
    public static final String RESULT_XPATH = "//div[@id='result']";

    public void setCheckBoxHome(boolean state){
        setCheckBox("Home", state);
    }

    public String getTextResultIfCheckBoxHomeEnable(){
        return getText(RESULT_XPATH);
    }

    public void verifyTextResultIfCheckBoxHomeEnable(){
        String textResult = "You have selected :\n" +
                "home\n" +
                "desktop\n" +
                "notes\n" +
                "commands\n" +
                "documents\n" +
                "workspace\n" +
                "react\n" +
                "angular\n" +
                "veu\n" +
                "office\n" +
                "public\n" +
                "private\n" +
                "classified\n" +
                "general\n" +
                "downloads\n" +
                "wordFile\n" +
                "excelFile";
        Assert.assertEquals(getTextResultIfCheckBoxHomeEnable(),textResult);
    }

}
