package homework1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class work
{
    public static void main(String[]args)
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.Argos.co.uk/");
        driver.manage().window().maximize();

        WebElement searchbox = driver.findElement(By.cssSelector("#searchTerm"));
        searchbox.sendKeys("Puma");

        WebElement search = driver.findElement(By.xpath("//button[@class='_2mKaC']"));
        search.click();

        WebElement checkbox = driver.findElement(By.xpath("//label[@id='filter-price-£5 - £10-label']//div[@class='Checkboxstyles__CheckboxOption-e3lxpy-3 esYLSA']//*[local-name()='svg']"));
        checkbox.click();

        WebElement trolley = driver.findElement(By.xpath("//body/main[@id='app']/div[@class='app app--search-lister']/div[@id='findability']/div/div[@class='search']/div[@class='styles__SearchContent-sc-1h5mbdb-2 CfHZq xs-row xs-auto--negative lg-auto--none']/div[@class='styles__Container-sc-1h5mbdb-0 gCgRbH xs-12--none lg-9--none xs-stack']/div[@class='styles__ProductList-sc-1rzb1sn-0 kChnTV']/div[1]/div[2]/button[1]/span[1]/span[1]"));
        trolley.click();

        WebElement trolley1 = driver.findElement(By.xpath("//a[@class='Buttonstyles__Button-q93iwm-2 dUQXJf']"));
        trolley1.click();
    }
}



class radiobutton
{
    public static void main(String[]args)
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.get("https://letskodeit.teachable.com/p/practice");
        driver.manage().window().maximize();

        WebElement BMW = driver.findElement(By.xpath("//input[@id='bmwradio']"));
        BMW.click();
        System.out.println(BMW.isSelected());//to verify it is selected or not.


        WebElement BENZ = driver.findElement(By.xpath("//input[@id='benzradio']"));
        BENZ.click();
        System.out.println(BENZ.isSelected());


        WebElement HONDA = driver.findElement(By.xpath("//input[@id='hondaradio']"));
        HONDA.click();
        System.out.println(HONDA.isSelected());
    }
}


class checkbox
{
    public static void main(String[]args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.get("https://letskodeit.teachable.com/p/practice");
        driver.manage().window().maximize();

        WebElement BMW1 = driver.findElement(By.xpath("//input[@id='bmwcheck']"));
        BMW1.click();

        WebElement BENZ1 = driver.findElement(By.xpath("//input[@id='benzcheck']"));
        BENZ1.click();

        WebElement HONDA1 = driver.findElement(By.xpath("//input[@id='hondacheck']"));
        HONDA1.click();
    }
}


