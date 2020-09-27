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

public class CalendarExample {
    public static WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.get("https://www.southalltravel.co.uk/");
        //driver.get("https://www.esky.co.uk/");
        driver.get("https://www.expedia.co.uk/");
        driver.manage().window().maximize();
    }

    @Test
    public void SouthallTravel() {
        WebElement Departingdatebox = driver.findElement(By.id("depdateit"));
        Departingdatebox.click();

        List<WebElement> alldates = driver.findElements(By.cssSelector(".ui-state-default"));

        for (WebElement date : alldates) {
            System.out.println(date.getText());

            if (date.getText().equals("15")) {
                date.click();
            }
        }
    }


    @Test
    public void esky() {
        WebElement departingfield = driver.findElement(By.id("departureDateRoundtrip0"));
        departingfield.click();

        List<WebElement> alldates = driver.findElements(By.cssSelector(".ui-state-default"));

        for (WebElement date : alldates) {
            System.out.println(date.getText());

            if (date.getText().contains("24")) {
                date.click();
            }
        }
    }


    @Test
    public void expedia()
    {

        WebElement flightbutton = driver.findElement(By.xpath("//body[contains(@class,'uitk-no-outline')]/div[@id='app']/div/div[contains(@class,'app-layer-base--active')]/div[contains(@class,'uitk-grid pageWhiteBackground')]/div[contains(@class,'uitk-cell Storefront-Homepage')]/div[contains(@class,'uitk-cell')]/div[contains(@class,'StorefrontWizardRegionBEX')]/div/figure[contains(@class,'uitk-image bexHeroImageFigure withBackgroundColor')]/div[contains(@class,'wizardCard all-t-padding-twelve all-x-padding-six SimpleContainer')]/div[contains(@class,'uitk-card uitk-grid all-cell-1-1 elevation-4')]/div[contains(@class,'uitk-cell lobFormInCard')]/div[contains(@class,'uitk-tabs-container')]/ul[@id='uitk-tabs-button-container']/li[contains(@class,'active')]/a[1]"));
        flightbutton.click();

        WebElement departing = driver.findElement(By.xpath("//button[@id='d1-btn']"));
        departing.click();

        WebElement sepcalendermonth = driver.findElement(By.xpath("//div[contains(@class,'uitk-calendar')]//div[1]//table[1]"));
        sepcalendermonth.click();

        System.out.println(sepcalendermonth.isDisplayed());

        List<WebElement> alldates = sepcalendermonth.findElements(By.cssSelector(".uitk-new-date-picker-day"));

        for(WebElement alldate : alldates)
        {
            System.out.println(alldate.getAttribute("data-day"));

            if(alldate.getAttribute("data-day").contains("21"))
            {
                alldate.click();
            }
        }
    }


}