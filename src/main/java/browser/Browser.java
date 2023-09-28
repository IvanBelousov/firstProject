package browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.time.Duration;

import static browser.Config.BROWSER_TYPE;
import static constants.Constant.TimeoutVariable.IMPLICIT_WAIT;

/**
 * Класс создан для упрощения объявления драйвера в тестах
 */
public class Browser {
    public static WebDriver driver; //Переменная driver, необходима для работы с драйвером

    /**
     * Инициализируется (необходимо для работы драйвера, иначе ошибка) драйвер, устанавливается разрешение экрана
     * и неявное ожидания
     * Переменная BROWSER_TYPE отвечает за открытие необходимого браузера
     * @return - возвращает экземпляр класса WebDriver
     */
    public static WebDriver createDriver(){ // создаём метод для создания драйвера
        switch (BROWSER_TYPE){
            case "chrome":
                System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir") + "\\drivers\\geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            default:
                Assert.fail ("Incorrect platform or browser name: " + BROWSER_TYPE);
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));
        return driver;
    }
}
