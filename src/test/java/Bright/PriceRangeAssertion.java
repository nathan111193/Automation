package Bright;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class PriceRangeAssertion {
    public static WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.argos.co.uk/search/nike/?clickOrigin=searchbar:home:term:nike");
        driver.manage().window().maximize();
    }

    @Test
    public void PriceAssertion() throws InterruptedException {
        WebElement PriceList = driver.findElement(By.xpath("//label[@id='filter-price-£5 - £10-label']"));
        Thread.sleep(5000);
        PriceList.click();

        List<WebElement> priceranges = driver.findElements(By.cssSelector(".ProductCardstyles__PriceText-l8f8q8-14.gHrEdF"));

        for (WebElement pricerange : priceranges) {
            //System.out.println(pricerange.getText());
            String actual = pricerange.getText().replace("£", " ");
            Double actualPrice = Double.parseDouble(actual);
            System.out.println(actualPrice);

            Assert.assertThat(actualPrice, Matchers.greaterThanOrEqualTo(5.00));
            Assert.assertThat(actualPrice, Matchers.lessThanOrEqualTo(10.00));
        }
    }
}
