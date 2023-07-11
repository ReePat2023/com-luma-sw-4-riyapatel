package com.softwaretestingboard.magento.testbase;

import com.softwaretestingboard.magento.utilities.Utility;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest extends Utility {
    String browser = "chrome";

    @BeforeMethod
    public void setup(){
        selectBrowser(browser);
    }

    @AfterMethod
    public void tearDon(){
        closeBrowser();
    }
}

