package com.softwaretestingboard.magento.utilities;

import com.softwaretestingboard.magento.browserfactory.ManageBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

public class Utility extends ManageBrowser {
        public void clickOnElement(By by) {

            driver.findElement(by).click();
        }

        /**
         * This method will send Text to element
         */
        public void sendTextToElement(By by, String text) {
            driver.findElement(by).sendKeys(text);
        }

        public String getTextFromElement(By by) {
            return driver.findElement(by).getText();
        }

        public String getAttributeValue(By by, String name) {
            return driver.findElement(by).getAttribute(name);
        }

        //************************* Alert Methods *****************************************************
        public void switchToAlert() {
            driver.switchTo().alert();
        }

        public void accept() {
            driver.switchTo().alert().accept();
        }

        public void dismiss() {
            driver.switchTo().alert().dismiss();
        }

        public String getTextFromAlert() {
            return driver.switchTo().alert().getText();
        }

        public void sendTextToAlert(String text) {
            driver.switchTo().alert().sendKeys(text);
        }

        //Homework- Create 5 methods
        //************************Select Class Methods*********************************************
        //We use select method when we have select tagname in DOM
        public void selectByVisibleTextFromDropDown(By by, String text) {
            WebElement dropDown = driver.findElement(by);
            Select select = new Select(dropDown);
            // Select by visible text
            select.selectByVisibleText(text);
        }

        public void selectByValueFromDropDown(By by, String text) {
            WebElement dropDown = driver.findElement(by);
            Select select = new Select(dropDown);
            select.selectByValue(text);

        }

        public void selectByIndexFromDropDown(By by, int index) {
            WebElement dropDown = driver.findElement(by);
            Select select = new Select(dropDown);
            select.selectByIndex(index);

        }

        /**
         * This method will select the option by contains text
         */
        //We use getOptions when select tagname is not available in the DOM
        public void selectByContainsTextFromDropDown(By by, String text) {
            List<WebElement> allOptions = new Select(driver.findElement(by)).getOptions();
            for (WebElement options : allOptions) {
                if (options.getText().contains(text)) {
                    options.click();
                }
            }
        }

//*************************** Window Handle Methods ***************************************//

        /**
         * This method will close all windows
         */
        public void closeAllWindows(List<String> hList, String parentWindow) {
            for (String str : hList) {
                if (!str.equals(parentWindow)) {
                    driver.switchTo().window(str).close();
                }
            }
        }

        /**
         * This method will switch to parent window
         */
        public void switchToParentWindow(String parentWindowId) {

            driver.switchTo().window(parentWindowId);
        }

        /**
         * This method will find that we switch to right window
         */
        public boolean switchToRightWindow(String windowTitle, List<String> hList) {
            for (String str : hList) {
                String title = driver.switchTo().window(str).getTitle();
                if (title.contains(windowTitle)) {
                    System.out.println("Found the right window....");
                    return true;
                }
            }
            return false;
        }
//*************************** Action Methods ***************************************//

        /**
         * This method will use to hover mouse on element
         */
        public void mouseHoverToElement(By by) {
            Actions actions = new Actions(driver);
            actions.moveToElement(driver.findElement(by)).build().perform();
        }

        /**
         * This method will use to hover mouse on element and click
         */
        public void mouseHoverToElementAndClick(By by) {
            Actions actions = new Actions(driver);
            actions.moveToElement(driver.findElement(by)).click().build().perform();
        }

        //************************** Waits Methods *********************************************//

        /**
         * This method will use to wait until  VisibilityOfElementLocated
         */
        public WebElement waitUntilVisibilityOfElementLocated(By by, int time) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
            return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        }

        public WebElement waitForElementWithFluentWait(By by, int time, int pollingTime) {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(time))
                    .pollingEvery(Duration.ofSeconds(pollingTime))
                    .ignoring(NoSuchElementException.class);

            WebElement element = wait.until(new Function<WebDriver, WebElement>() {
                public WebElement apply(WebDriver driver) {
                    return driver.findElement(by);
                }
            });
            return element;
        }
    }
}