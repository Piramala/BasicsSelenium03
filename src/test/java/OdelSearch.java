import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class OdelSearch {
    WebDriver driver;
    @BeforeTest
    public void initBrowser()
    {
        driver= WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.get("https://odel.lk/home");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    @Test
    public void searchHat() throws InterruptedException {
        new Actions(driver).moveToElement(driver.findElement(By.xpath("//a[text()='WOMEN']/parent::div"))).perform();
        Thread.sleep(4000);
        new Actions(driver).moveToElement(driver.findElement(By.xpath("//a[text()='WOMEN']/parent::div//a[text()='Accessories']/following-sibling::ul//a[text()='Caps & Hats']"))).perform();
        Thread.sleep(4000);
        driver.findElement(By.xpath("//a[text()='WOMEN']/parent::div//a[text()='Accessories']/following-sibling::ul//a[text()='Caps & Hats']")).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("//span[text()='Brands']")).click();
        Thread.sleep(4000);




    }
    @AfterTest
    public void quitBrowser()
    {
        driver.quit();
    }

}
