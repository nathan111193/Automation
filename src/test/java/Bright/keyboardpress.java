package Bright;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class keyboardpress
{

        public static ChromeDriver driver;

        @Before
        public void setup()
        {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
            //driver.get("https://letskodeit.teachable.com/");
            driver.get("https://demoqa.com/text-box");
            driver.manage().window().maximize();
        }

        @Test
    public void keyPress() throws InterruptedException {
            WebElement loginButton = driver.findElement(By.xpath("//a[@class='navbar-link fedora-navbar-link']"));
            loginButton.click();
            Thread.sleep(4000);

            WebElement username = driver.findElement(By.id("user_email"));
            username.sendKeys("abc@gmail.com");
            username.sendKeys(Keys.TAB);
            Thread.sleep(4000);

            WebElement password = driver.findElement(By.id("user_password"));
            password.sendKeys("123456");
            password.sendKeys(Keys.ENTER);
        }

        @Test
    public void combineKeyPress() throws InterruptedException {
            WebElement curAddr = driver.findElement(By.id("currentAddress"));
            WebElement perAddr = driver.findElement(By.id("permanentAddress"));

            Actions actions = new Actions(driver);
            actions.click(curAddr).sendKeys("38, meadow way, wembley").perform();
            Thread.sleep(15000);

            actions.keyDown(curAddr,Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
            Thread.sleep(15000);

            actions.keyDown(Keys.CONTROL).sendKeys("c").keyUp(perAddr,Keys.CONTROL).perform();
            Thread.sleep(15000);

            actions.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
            Thread.sleep(15000);


        }

    }
