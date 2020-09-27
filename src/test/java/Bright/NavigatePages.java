package Bright;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class NavigatePages
{
    public static WebDriver driver;
    @Before
    public void setup()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://letskodeit.teachable.com");
        driver.manage().window().maximize();
    }
    @Test
    public void Test1() throws InterruptedException
    {
        Thread.sleep(5000);
        driver.navigate().to("https://sso.teachable.com/secure/42299/users/sign_in?clean_login=true&reset_purchase_session=1");
        driver.navigate().back();
        driver.navigate().forward();
    }
    @After
    public void tearDown()
    {
        //driver.quit();
    }
}
