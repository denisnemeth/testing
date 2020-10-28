package sk.itsovy.nemethd;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class QuickTest {

    public static void main(String[] args) {

        String url = "https://www.testandquiz.com/selenium/testing.html";

        // Initialization
        System.setProperty("webdriver.chrome.driver", "D:\\SCHOOL\\Other\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // Open a website
        driver.manage().window().maximize();
        driver.get(url);
        //or driver.navigate().to(url);

        System.out.println();

        // Get the title of the website
        String testPageTitle = driver.getTitle();
        System.out.println(testPageTitle);

        //System.out.println();

        // Get the source code of the website
        //System.out.println(driver.getPageSource());

        System.out.println();

        // Get an element and print it
        System.out.println(driver.findElement(By.className("col-md-12")).getText());
        System.out.println(driver.findElement(By.cssSelector("b")).getText());

        System.out.println();

        // Get the current url
        System.out.println(driver.getCurrentUrl());

        // Open a link in a new tab
        driver.findElement(By.linkText("This is a link")).sendKeys(Keys.CONTROL, Keys.RETURN);

        /*// Switch to the other tab
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, "\t");

        // Switch back to the test page
        driver.switchTo().window(testPageTitle);*/

        // Write in a textbox and then clear it
        driver.findElement(By.id("fname")).sendKeys("sample text");
        driver.findElement(By.id("fname")).clear();

        // Click a button, radio button and a checkbox
        driver.findElement(By.id("idOfButton")).click();
        driver.findElement(By.id("male")).click();
        driver.findElement(By.cssSelector("input.Automation")).click();

        // Scroll down
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,1000)");

        // Select something from a dropdown menu
        driver.findElement(By.id("testingDropdown")).click();
        Select dropdown = new Select(driver.findElement(By.id("testingDropdown")));
        dropdown.selectByVisibleText("Manual Testing");
        driver.findElement(By.id("testingDropdown")).click();

        // Double click a button and then click OK on alert
        Actions actions = new Actions(driver);
        WebElement elementLocator = driver.findElement(By.id("dblClkBtn"));
        actions.doubleClick(elementLocator).perform();
        driver.switchTo().alert().accept();

        // Click cancel on alert
        driver.findElement(By.xpath("//*[contains(text(), 'Generate Confirm Box')]")).click();
        driver.switchTo().alert().dismiss();

        // Refresh the page
        driver.navigate().refresh();

        // Close the current tab
        driver.close();

        // Close the driver
        driver.quit();
    }
}
