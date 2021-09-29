package gr.xe.selenium.qaChallenge;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestOne {
    @Test(priority = 0, description = "Visit the xe.gr homepage, select the property tab and press search.")
    public void Test1() {
        String path = System.getProperty("user.dir");

        String chromeDriverPath = path + "/src/main/resources/chromedriver.exe";

        System.setProperty("webdriver.chrome.driver", chromeDriverPath);

        WebDriver driver = new ChromeDriver();

        driver.navigate().to("https://www.xe.gr/");

        //Select the property tab
        driver.findElement(By.cssSelector("#property-tab")).click();
        //Click search button
        driver.findElement(By.cssSelector("[data-testid='submit-input']")).click();
        //Click the first search result
        driver.findElement(By.cssSelector("[data-testid='property-ad-url']")).click();

        driver.quit();
    }
}
