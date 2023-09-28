import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
        driver.get("https://demoqa.com/checkbox");
        driver.manage().window().maximize();
        WebElement checkBox = driver.findElement(By.xpath("//input[@id='tree-node-home']"));
        checkBox.isSelected();
        checkBox.click();
       /* sleep(1000);
        WebElement fullName = driver.findElement(By.xpath("//input[@placeholder='Full Name']"));
        fullName.sendKeys("Ivan");
        WebElement submit = driver.findElement(By.xpath("//button[text()='Submit']"));
        submit.click();
        WebElement output = driver.findElement(By.xpath("//div[@id='output']//p"));
        output.getText();
        fullName.getAttribute("value");
        fullName.clear();
        submit.isDisplayed();*//*
        WebElement dynamicProperties = driver.findElement(By.xpath("//span[contains(text(),'Dynamic Properties')]"));
        *//*Actions actions = new Actions(driver);
        actions.scrollToElement(driver.findElement(By.xpath("//div[@class='header-wrapper']/div[contains(text(),'Forms')]"))).build().perform();
        dynamicProperties.click();*//*
        //или
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", dynamicProperties);
        dynamicProperties.click();
        //WebElement buttonWillEnable = driver.findElement(By.xpath("//button[contains(text(),'Will enable 5 seconds')]"));
        //boolean s = buttonWillEnable.isEnabled();
        //WebElement buttonAfter = driver.findElement(By.xpath("//button[contains(text(),'Visible After 5 Seconds')]"));
        *//*WebElement buttonAfter = (new WebDriverWait(driver,Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(text(),'Visible After 5 Seconds')]"))));
        buttonAfter.isDisplayed();*//*
        WebElement buttonWillEnable = (new WebDriverWait(driver,Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Will enable 5 seconds')]"))));
        boolean s = buttonWillEnable.isEnabled();
        System.out.println();
        sleep(10000);*/


    }
}
