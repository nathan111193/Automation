/*package Bright;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ImplicitWaitDemo {
    public static WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://letskodeit.teachable.com/");
        driver.manage().window().maximize();
    }

    @Test
    public void implicit() {
        WebElement loginButton = driver.findElement(By.linkText("Login"));
        loginButton.click();

        WebElement username = driver.findElement(By.id("user_email"));
        username.sendKeys("test");
    }

    @Test
    public void explicit() {
        WebElement loginButton = driver.findElement(By.linkText("Login"));
        loginButton.click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_email")));
        username.sendKeys("test");
    }
}

*/