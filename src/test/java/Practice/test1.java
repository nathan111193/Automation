package Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class test1
{
    public static WebDriver driver;

    @Before
    public void setup()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        //driver.get("https://www.argos.co.uk/browse/technology/home-audio/wireless-and-bluetooth-speakers/c:30133/brands:bose/?tag=ar:shop:bose:wireless-speakers");
        //driver.get("https://www.southalltravel.co.uk/");
        //driver.get("https://www.travelsupermarket.com/en-gb/flights/");
        driver.get("https://letskodeit.teachable.com/p/practice");
        driver.manage().window().maximize();
    }

    @Test
    public void argosCheckboxes()
    {
        List<WebElement> checkboxes = driver.findElements(By.cssSelector(".Checkboxstyles__Label-e3lxpy-4.hWEwsp.font-standard"));

        for (WebElement checkbox : checkboxes)
        {
            System.out.println(checkbox.getAttribute("id"));

            if (checkbox.getAttribute("id").contains("filter-type-docking stations-label")) {
                checkbox.click();
            }
        }
    }


    @Test
    public void flight()
    {
        WebElement depart = driver.findElement(By.id("depdateit"));
        depart.click();

        List<WebElement> dates = driver.findElements(By.className("ui-state-default"));

        for (WebElement date : dates)
        {
            System.out.println(date.getText());

            if (date.getText().contains("29"))
            {
                date.click();
            }
        }
    }




    //homework 2

    @Test
    public void codeit()
    {
        List<WebElement> radios = driver.findElements(By.cssSelector("input[type=radio]"));

       for(WebElement radio : radios)
       {
           System.out.println(radio.getAttribute("id"));

           if(radio.getAttribute("id").contains("benzradio"))
           {
               radio.click();
           }
       }
    }




    @Test
    public void kodeit()
    {
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type=checkbox]"));

        for(WebElement checkbox : checkboxes)
        {
            System.out.println(checkbox.getAttribute("id"));

            if(checkbox.getAttribute("id").contains("benzcheck"))
            {
                checkbox.click();
            }
        }
    }


    @Test
    public void navigate()
    {
        driver.navigate().to("https://google.com");
        driver.navigate().forward();
        driver.navigate().back();
    }
}