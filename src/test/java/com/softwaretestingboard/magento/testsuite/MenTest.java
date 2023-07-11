package com.softwaretestingboard.magento.testsuite;

import com.softwaretestingboard.magento.pages.MenPage;
import com.softwaretestingboard.magento.testbase.BaseTest;
import junit.framework.Assert;
import org.testng.annotations.Test;

public class MenTest extends BaseTest {
    MenPage menPage = new MenPage();

    @Test
    public void userShouldAddProductSuccessFullyToShoppingCart() {
        /// Mouse Hover on Men Menu
        menPage.mouseHoverOnMenMenu();
        //Mouse Hover on Bottoms
        menPage.mouseHoverOnBottoms();
        ////Click on Pants
        menPage.clickOnPants();

        menPage.sortByProductName();
        ////* Mouse Hover on product name‘Cronus Yoga Pant’ and click on size 32.
        //menTest.cronusYogaPantAndClickOnSize32();
        menPage.clickOnCronousSize32();
        ////Mouse Hover on product name‘Cronus Yoga Pant’ and click on colour Black.
        //menTest.cronusYogaPantAndColourBlack();
        menPage.clickOnCronousBlack();
        menPage.mouseHoverOnCronusYogaAndClickAddCart();

        // Verify the text ‘You added Cronus Yoga Pant to your shopping cart.’
        Assert.assertEquals(menPage.getSuccessMsgText(), "You added Cronus Yoga Pant to your shopping cart.");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        menPage.clickOnShoppingCartLink();

        // Verify the text ‘Shopping Cart.’
        Assert.assertEquals(menPage.getShoppingCartText(), "Shopping Cart");
        // Verify the product name ‘Cronus Yoga Pant’
        Assert.assertEquals(menPage.getProductName(), "Cronus Yoga Pant");
        // Verify the product size ‘32’
        Assert.assertEquals(menPage.getProductSize(), "32");
        // Verify the product colour ‘Black’
        Assert.assertEquals(menPage.getProductColour(), "Black");

    }
}
