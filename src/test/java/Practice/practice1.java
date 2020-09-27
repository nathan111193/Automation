package Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class practice1
{
    public static ChromeDriver driver;

    @Before
    public void setup()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        //driver.get("https://www.argos.co.uk/search/nike/?clickOrigin=searchbar:home:term:nike");
        //driver.get("https://www.southalltravel.co.uk/");
        //driver.get("https://letskodeit.teachable.com/p/practice");
        driver.get("https://www.opodo.co.uk/");
        //driver.get("https://www.southalltravel.co.uk/");
        driver.manage().window().maximize();
    }

    @Test
    public void test()
    {
        List<WebElement> checkboxes = driver.findElements(By.cssSelector(".Checkboxstyles__Label-e3lxpy-4.hWEwsp.font-standard"));

        for(WebElement checkbox : checkboxes)
        {
            System.out.println(checkbox.getAttribute("id"));
            if(checkbox.getAttribute("id").contains("filter-type-smartwatch-label"))
            {
                checkbox.click();
            }
        }
    }


    @Test
    public void test1()
    {
        WebElement arrival = driver.findElement(By.id("retdateit"));
        arrival.click();

        List<WebElement> dates = driver.findElements(By.cssSelector(".ui-state-default"));

        for(WebElement date : dates)
        {
            System.out.println(date.getText());
            if(date.getText().contains("15"))
            {
                date.click();
            }
        }
    }


    @Test
    public void test2()
    {
        List<WebElement> products = driver.findElements(By.cssSelector(".ProductCardstyles__ImageWrapper-l8f8q8-3.hocfCx"));

        for (WebElement product : products)
        {
            System.out.println(product.getAttribute("class"));

            if(product.getAttribute("class").contains("ProductCardstyles__ImageWrapper-l8f8q8-3 hocfCx"))
            {
                product.click();
            }
        }
    }

   /* @Test
    public void scroll()
    {
        WebElement table = driver.findElement(By.xpath("//legend[contains(text(),'Web Table Example')]"));

        JavascriptExecutor js = (JavascriptExecutor)driver;

        js.executeScript("arguments[0].scrollIntoView(true);", table);
        js.executeScript("window.scrollBy(0,-190);");
    }*/


    @Test
    public void multipleoptions() throws InterruptedException {
        WebElement dropdown = driver.findElement(By.xpath("//select[@id='carselect']"));

        Select sel = new Select(dropdown);

        sel.selectByIndex(0);
        Thread.sleep(3000);

        sel.selectByValue("benz");
        Thread.sleep(3000);

        sel.selectByVisibleText("Honda");
        Thread.sleep(3000);
    }

    @Test
    public void dropdown1()
    {
        WebElement dropdown2 = driver.findElement(By.xpath("//select[@id='multiple-select-example']"));

        Select sel = new Select(dropdown2);

        sel.selectByIndex(0);
        sel.selectByValue("orange");
        sel.selectByVisibleText("Peach");
    }


    @Test
    public void southall1()
    {
        WebElement departfrom = driver.findElement(By.id("DestinationFrom1"));
        departfrom.sendKeys("Lon");

        List<WebElement> airports = driver.findElements(By.cssSelector(".ui-menu-item"));

        for(WebElement airport : airports)
        {
            System.out.println(airport.getText());

            if(airport.getText().contains("London Gatwick (LGW), UK"))
            {
                airport.click();
            }
        }
    }


    @Test
    public void opodo() throws InterruptedException {
        WebElement calendar = driver.findElement(By.cssSelector(".od-ui-datepicker-field.wl-bookingcom-input.placeholder"));
        calendar.click();

        WebElement sepcalendar = driver.findElement(By.cssSelector(".od-ui-calendar-month"));

        List<WebElement> alldates = sepcalendar.findElements(By.cssSelector(".od-ui-calendar-day"));

        for (WebElement alldate : alldates)
        {
            System.out.println(alldate.getText());
            Thread.sleep(4000);

            if (alldate.getText().equals("15"))
            {
                Thread.sleep(4000);
                alldate.click();
            }
        }
    }
}
