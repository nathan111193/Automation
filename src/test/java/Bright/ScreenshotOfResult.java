package Bright;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ScreenshotOfResult
{
    public static ChromeDriver driver;

    @Before
    public void setup()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        driver.get("https://en-gb.facebook.com/");
        driver.manage().window().maximize();
    }

    @Test
    public void result() throws InterruptedException, IOException {
        WebElement loginbutton = driver.findElement(By.id("u_0_d"));
        loginbutton.click();

        Thread.sleep(5000);

        File sourcefile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File destinationfile = new File("Nathan/Users/nathanpereira/Desktop/");
        FileUtils.copyFile(sourcefile,destinationfile);
    }
}
