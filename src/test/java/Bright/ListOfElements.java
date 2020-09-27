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

public class ListOfElements
{
    public static WebDriver driver;

    @Before
    public void setup()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://www.argos.co.uk/search/nike/?clickOrigin=searchbar:home:term:nike");
        driver.manage().window().maximize();
    }


    @Test
    public void argosRadioButton()
    {
        List<WebElement> radiobuttons = driver.findElements(By.cssSelector(".RadioListstyles__Label-sc-4132xt-5.gywEET"));

        for(WebElement radiobutton : radiobuttons)
        {
            System.out.println(radiobutton.getAttribute("id"));

            if (radiobutton.getAttribute("id").contains("4 or more-label"))
            {
                radiobutton.click();
            }
        }
    }

    @Test
    public void argosCheckBoxList()
    {
        List<WebElement> checkboxes = driver.findElements(By.cssSelector(".Checkboxstyles__Label-e3lxpy-4.hWEwsp.font-standard"));


        for (WebElement checkbox : checkboxes)
        {
            System.out.println(checkbox.getAttribute("id"));

            if (checkbox.getAttribute("id").contains("filter-price-£10 - £15-label"))
            {
                checkbox.click();
            }
        }
    }
}
