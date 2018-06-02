import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.List;
import java.util.concurrent.TimeUnit;

public class BaseScript {
    public static void main(String[] args) {
        WebDriver driver = initChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://bing.com");
        WebElement field = driver.findElement(By.id("sb_form_q"));
        field.sendKeys("Selenium");
        WebElement button = driver.findElement(By.name("go"));
        button.click();
        List<WebElement> list = driver.findElements(By.className("b_algo"));
        System.out.println(list.size());
        driver.quit();
    }

    public static WebDriver initChromeDriver() {
        System.setProperty("webdriver.chrome.driver", BaseScript.class.getResource("chromedriver.exe").getPath());
        return new ChromeDriver();
    }
}
