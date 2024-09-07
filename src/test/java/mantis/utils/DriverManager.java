package mantis.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class DriverManager {
    private static WebDriver driver;

    public static WebDriver obterDriver() {
        if (driver == null) {
            String chromeDriverPath = new File("src/test/resources/drivers/chromedriver.exe").getAbsolutePath();
            System.setProperty("webdriver.chrome.driver", chromeDriverPath);

            // Inicializa o ChromeDriver sem opções
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        return driver;
    }


    public static void encerrarDriver() {
        if (driver != null) {
            try {
                driver.manage().deleteAllCookies();
                driver.quit();
                System.out.println("Driver encerrado com sucesso.");
            } catch (Exception e) {
                System.err.println("Erro ao encerrar o driver: " + e.getMessage());
            } finally {
                driver = null;
            }
        }
    }


    public static void waitElementVisiblePage(WebElement element, int time) {
        WebDriverWait wait = new WebDriverWait(obterDriver(), time);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitElementClickable(WebElement element, int time) {
        WebDriverWait wait = new WebDriverWait(obterDriver(), time);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

}
