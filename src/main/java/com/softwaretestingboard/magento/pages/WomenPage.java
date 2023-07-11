package com.softwaretestingboard.magento.pages;

import com.softwaretestingboard.magento.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class WomenPage extends Utility {
    By womenMenu = By.xpath("//a[@id='ui-id-4']//span[contains(text(),'Women')]");
    By tops = By.linkText("Tops");
    By clickOnJackets = By.linkText("Jackets");
    By productList = By.xpath("//strong[@class='product name product-item-name']");
    By priceList = By.xpath("//span[@class='price-wrapper ']//span");
    By selectByFilterProductName = By.xpath("//div[2]//div[3]//select[1]");
    By selectByFilterPrice = By.xpath("//select[@id='sorter']");

    public void mouseHoverOnWomen() {
        mouseHoverToElement(womenMenu);
    }

    public void mouseHoverOnTop() {
        mouseHoverToElement(tops);
    }

    public void clickOnJacket() {
        clickOnElement(clickOnJackets);
    }

    public ArrayList<String> defaultProductList() {
        // Get all the products name and stored into array list
        List<WebElement> jacketsElementsList = driver.findElements(productList);
        ArrayList<String> jacketsNameListBefore = new ArrayList<>();
        for (WebElement e : jacketsElementsList) {
            jacketsNameListBefore.add(e.getText());
        }
        System.out.println(jacketsNameListBefore);
        return jacketsNameListBefore;

    }

    public ArrayList<String> afterSortingByProductName() {
        List<WebElement> jacketElementsList = driver.findElements(productList);
        ArrayList<String> jacketNameAfter = new ArrayList<>();
        for (WebElement value : jacketElementsList) {
            jacketNameAfter.add(value.getText());
        }
        System.out.println(jacketNameAfter);
        return jacketNameAfter;
    }

    public ArrayList<Double> defaultProductsPriceList() {
        // Get all the products name and stored into array list
        List<WebElement> jacketsElementsList = driver.findElements(priceList);
        ArrayList<Double> jacketsPriceListBefore = new ArrayList<>();
        for (WebElement e : jacketsElementsList) {
            jacketsPriceListBefore.add(Double.valueOf(e.getText().replace("$", "")));
        }
        System.out.println(jacketsPriceListBefore);
        return jacketsPriceListBefore;
    }


    public ArrayList<Double> afterSortingByProductsPriceList() {
        List<WebElement> jacketElementsList = driver.findElements(priceList);
        ArrayList<Double> jacketPriceAfter = new ArrayList<>();
        for (WebElement value : jacketElementsList) {
            jacketPriceAfter.add(Double.valueOf(value.getText().replace("$", "")));
        }
        System.out.println(jacketPriceAfter);
        return jacketPriceAfter;
    }
    public void selectFilterFromDropDownList () {
        clickOnElement(selectByFilterProductName);
    }

    public void setSelectByFilterPrice () {
        selectByValueFromDropDown(selectByFilterPrice, "price");

    }
}
