package Bright;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MultipleSelectOptions
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
    public void multipleSelectOptions() throws InterruptedException
    {
        WebElement multipleoptionbox = driver.findElement(By.id("multiple-select-example"));

        Select sel = new Select(multipleoptionbox);

        sel.selectByIndex(0);
        Thread.sleep(3000);
        sel.deselectByIndex(0);

        sel.selectByValue("orange");
        Thread.sleep(3000);

        sel.selectByVisibleText("Peach");
        Thread.sleep(3000);

        //List<WebElement> options = sel.getOptions();
        List<WebElement> options = sel.getAllSelectedOptions();

        for(WebElement option : options)
        {
            System.out.println(option.getText());
        }
    }

    @Test
    public void dropdownoptions() throws InterruptedException
    {
        WebElement dropdownbox = driver.findElement(By.id("carselect"));

        Select sel = new Select(dropdownbox);

        sel.selectByIndex(0);
        Thread.sleep(3000);

        sel.selectByValue("benz");
        Thread.sleep(3000);

        sel.selectByVisibleText("Honda");
        Thread.sleep(3000);
    }

}
