package gr.xe.selenium.qaChallenge;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


public class TestTwo {
    @Test(priority = 0, description = "Visit the xe.gr homepage, make it full screen, select houses for sale from the dropdown menus and press search.")
    public void Test2(){
        String path = System.getProperty("user.dir");

        String chromeDriverPath = path + "/src/main/resources/chromedriver.exe";

        System.setProperty("webdriver.chrome.driver", chromeDriverPath);

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 15);

        driver.navigate().to("https://www.xe.gr/");

        //Maximize window
        driver.manage().window().maximize();

        //Select property tab
        driver.findElement(By.cssSelector("#property-tab")).click();

        //Select from dropdown menu the buy option
        driver.findElement(By.cssSelector("[data-testid='property-transaction-class']")).click();
        driver.findElement(By.cssSelector("[data-testid='buy']")).click();

        //Select also from dropdown menu the residence option
        driver.findElement(By.cssSelector("[data-testid='property-type-class']")).click();
        driver.findElement(By.cssSelector("[data-testid='re_residence']")).click();

        //Click search button
        driver.findElement(By.cssSelector("[data-testid='submit-input']")).click();

        //Select price filter
        driver.findElement(By.cssSelector("[data-testid='price-filter']")).click();
        //Insert your preferred price value and press enter
        driver.findElement(By.cssSelector("[data-testid='minimum_price_input']")).sendKeys("value","500000");
        driver.findElement(By.cssSelector("[data-testid='minimum_price_input']")).sendKeys(Keys.ENTER);
        //Close price filter tab
        driver.findElement(By.cssSelector("[data-testid='price-filter']")).click();

        //Get the price value of the first search result
        String p= wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-testid='property-ad-price']"))).getText();
        //Select the first search result (wait until the button is clickable)
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-testid='property-ad-price']"))).click();

        //Split value
        String price_value=p.split(" ",0)[0];
        //Replace "." with ""
        price_value=price_value.replaceAll("[^\\d]", "");
        int price=Integer.valueOf(price_value);

        //Check if the price range is correct
        if(price>=500000)
        {
            System.out.printf("Correct");
        }
        else
        {
            System.out.printf("Error in filtering price");
        }

        driver.quit();
    }
}
