package Bright;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class JavaScriptScroll
{
    public static WebDriver driver;

    @Before
    public void setup()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.get("https://letskodeit.teachable.com/p/practice");
        driver.manage().window().maximize();
    }

    @Test
    public void scrollPageUpDown() throws InterruptedException
    {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        Thread.sleep(3000);

        /*js.executeScript("window.scrollBy(0,1900);");
        Thread.sleep(3000);

        js.executeScript("window.scrollBy(0,-1900);");
        Thread.sleep(3000);*/

        WebElement mousehover = driver.findElement(By.id("mousehover"));

        js.executeScript("arguments[0].scrollIntoView(true);", mousehover);
        js.executeScript("window.scrollBy(0,-190);");

    }
}
