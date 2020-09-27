package Bright;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AutocompleteDropdown
{
    public static WebDriver driver;

    @Before
    public void setup()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.get("https://www.southalltravel.co.uk/");
        driver.manage().window().maximize();
    }

    @Test
    public void southall() throws InterruptedException
    {
        WebElement departfrom = driver.findElement(By.id("DestinationFrom1"));
        departfrom.sendKeys("Lon");
        Thread.sleep(3000);

        List<WebElement> departdropdowns = driver.findElements(By.cssSelector(".ui-menu-item-wrapper"));

        for (WebElement departdropdown : departdropdowns)
        {
            System.out.println(departdropdown.getText());

            if(departdropdown.getText().contains("London Heathrow Airport (LHR), UK"))
            {
                departdropdown.click();
            }
        }
    }
}
