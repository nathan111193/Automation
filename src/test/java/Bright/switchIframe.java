package Bright;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class switchIframe
{
    public static ChromeDriver driver;

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
    public void iframe() throws InterruptedException
    {
        Thread.sleep(5000);
        driver.switchTo().frame(0);

        WebElement searchCourse = driver.findElement(By.id("search-courses"));
        searchCourse.sendKeys("java");

        Thread.sleep(4000);
        driver.switchTo().defaultContent();

        Thread.sleep(4000);
        WebElement bmwradio = driver.findElement(By.id("bmwradio"));
        bmwradio.click();
    }
}


//first
//own branch
//undo uncommited