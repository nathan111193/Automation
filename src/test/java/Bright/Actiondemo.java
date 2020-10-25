package Bright;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class Actiondemo
{
    public static ChromeDriver driver;

    @Before
    public void setup()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://letskodeit.teachable.com/p/practice");
        driver.manage().window().maximize();
    }

   /* @Test
    public void action() throws InterruptedException {

        WebElement mouseHover = driver.findElement(By.id("mousehover"));

        Thread.sleep(4000);
        Actions actions = new Actions(driver);
        actions.moveToElement(mouseHover).perform();

        Thread.sleep(4000);
        WebElement subelement = driver.findElement(By.xpath("//a[contains(text(),'Top')]"));
        actions.moveToElement(subelement).click().perform();

    }*/


    @Test
    public void action()
    {
        WebElement hover = driver.findElement(By.id("mousehover"));

        Actions actions = new Actions(driver);
        actions.moveToElement(hover).perform();

        WebElement reload = driver.findElement(By.xpath("//a[contains(text(),'Reload')]"));
        actions.moveToElement(reload).click().perform();
    }
}
