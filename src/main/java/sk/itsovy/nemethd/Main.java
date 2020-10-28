package sk.itsovy.nemethd;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Main {

    public static void main(String[] args) {

        String url = "https://www.testandquiz.com/selenium/testing.html";

        try {

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

            //Thread.sleep(2000);
            //System.out.println();

            // Get the source code of the website
            //System.out.println(driver.getPageSource());

            Thread.sleep(2000);
            System.out.println();

            // Get an element and print it
            System.out.println(driver.findElement(By.className("col-md-12")).getText());
            System.out.println(driver.findElement(By.cssSelector("b")).getText());

            System.out.println();
            Thread.sleep(2000);

            // Get the current url
            System.out.println(driver.getCurrentUrl());

            Thread.sleep(2000);

            // Open a link in a new tab
            driver.findElement(By.linkText("This is a link")).sendKeys(Keys.CONTROL, Keys.RETURN);

            /*Thread.sleep(2000);

            // Switch to the other tab
            driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, "\t");

            Thread.sleep(2000);

            // Switch back to the test page
            driver.switchTo().window(testPageTitle);*/

            Thread.sleep(2000);

            // Write in a textbox and then clear it
            driver.findElement(By.id("fname")).sendKeys("sample text");
            Thread.sleep(2000);
            driver.findElement(By.id("fname")).clear();

            Thread.sleep(2000);

            // Click a button, radio button and a checkbox
            driver.findElement(By.id("idOfButton")).click();
            Thread.sleep(2000);
            driver.findElement(By.id("male")).click();
            Thread.sleep(2000);
            driver.findElement(By.cssSelector("input.Automation")).click();

            Thread.sleep(2000);

            // Scroll down
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("window.scrollBy(0,1000)");

            Thread.sleep(2000);

            // Select something from a dropdown menu
            driver.findElement(By.id("testingDropdown")).click();
            Thread.sleep(2000);
            Select dropdown = new Select(driver.findElement(By.id("testingDropdown")));
            dropdown.selectByVisibleText("Manual Testing");
            driver.findElement(By.id("testingDropdown")).click();

            Thread.sleep(2000);

            // Double click a button and then click OK on alert
            Actions actions = new Actions(driver);
            WebElement elementLocator = driver.findElement(By.id("dblClkBtn"));
            actions.doubleClick(elementLocator).perform();
            Thread.sleep(2000);
            driver.switchTo().alert().accept();

            Thread.sleep(2000);

            // Click cancel on alert
            driver.findElement(By.xpath("//*[contains(text(), 'Generate Confirm Box')]")).click();
            Thread.sleep(2000);
            driver.switchTo().alert().dismiss();

            Thread.sleep(2000);

            // Refresh the page
            driver.navigate().refresh();

            Thread.sleep(2000);

            // Close the current tab
            driver.close();

            Thread.sleep(2000);

            // Close the driver
            driver.quit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}