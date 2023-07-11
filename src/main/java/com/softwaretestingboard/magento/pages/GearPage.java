package com.softwaretestingboard.magento.pages;

import com.softwaretestingboard.magento.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GearPage extends Utility {
    By gearMenu = By.xpath("(//span[@class='ui-menu-icon ui-icon ui-icon-carat-1-e'])[7]");
    By bags = By.xpath("//span[normalize-space()='Bags']");
    By overnightDuffle = By.xpath("//strong[@class='product name product-item-name']//a[contains(text(),'Overnight Duffle ')]");
    By verifyText = By.xpath("//dd[contains(text(),'Black')]");
    By changeQty = By.id("qty");
    By addToCart = By.xpath("//span[contains(text(),'Add to Cart')]");
    By changeQty5 =By.xpath("//div[@class='control qty']//input");
    By upDateCart = By.xpath("//span[contains(text(),'Update Shopping Cart')]");
    By clickOnShoppingCart = By.xpath("//a[contains(text(),'shopping cart')]");
    By txtAddedDuffleToCart = By.xpath("//body/div[1]/main[1]/div[1]/div[2]/div[1]/div[1]/div[1]");
    By productName = By.xpath("//tbody/tr[1]/td[1]/div[1]/strong[1]/a[1]");
    By verifyQty3= By.xpath("//div[@class='control qty']//input");
    By verifyProductPrice=By.xpath("//td[@class='col subtotal']//span[@class='price']");

    public void mouseHoverOnGear() {
        mouseHoverToElement(gearMenu);

    }

    public void clickOnBags() {
        clickOnElement(bags);
    }

    public void clickOnProductName() {
        clickOnElement(overnightDuffle);

    }

    public void changeQty() {
        driver.findElement(changeQty).clear();
        driver.findElement(changeQty).sendKeys("3");
    }

    public void clickOnAddToCart() {
        clickOnElement(addToCart);
    }

    // Change Qty to ‘5’
    public void changeQty5() {
        driver.findElement(changeQty5).clear();
        driver.findElement(changeQty5).sendKeys("5");
    }
    public void updateCart(){
        clickOnElement(upDateCart);
    }

    private void verify(String xpath, String msg) {
        List<WebElement> m1Element = driver.findElements(By.xpath("//strong[@class='product-item-name']"));
        for (WebElement list : m1Element) {
            String name1 = list.getText();
            System.out.println(name1);

        }
    }

    public void clickOnShoppingCart() {
        clickOnElement(clickOnShoppingCart);
    }
    public String getProductNameText(){
        return getTextFromElement(productName);
    }
    public String getTextAddedDuffleToCart(){
        return getTextFromElement(txtAddedDuffleToCart);
    }

    public String getQtyText() {
        return getAttributeValue(verifyQty3, "value");
    }

    public String getProductPrice() {
        return getTextFromElement(verifyProductPrice);
    }
}
