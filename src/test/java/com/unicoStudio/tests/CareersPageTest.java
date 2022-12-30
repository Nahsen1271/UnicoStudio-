package com.unicoStudio.tests;

import com.unicoStudio.pages.AboutPage;
import com.unicoStudio.pages.CareersPage;
import com.unicoStudio.pages.HomePage;
import com.unicoStudio.utilities.BrowserUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class CareersPageTest extends TestBase{

    AboutPage aboutPage=new AboutPage();
    HomePage homePage=new HomePage();
    CareersPage careersPage= new CareersPage();

    @Test
    public void careersPageTest() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click();", homePage.careersBtn);
//        homePage.learnAboutUs.click();
        String careersPageTitle = driver.getTitle();
        System.out.println("careersPageTitle = " + careersPageTitle);

        Assert.assertTrue(careersPageTitle.contains("Careers"));

        String whatWeOfferText = careersPage.whatWeOffer.getText();
        System.out.println("whatWeOfferText = " + whatWeOfferText);

        Assert.assertTrue(whatWeOfferText.contains("What do we offer?"));


        List<String> expectedList= BrowserUtils.getElementsTextWithAttribute(careersPage.whatWeOfferSub);
        System.out.println("expectedList = " + expectedList);
       // Assert.assertTrue(expectedList.containsAll("Amazing Team, Remote Working"));

      //  careersPage.checkOpenings.click();
//        jse.executeScript("arguments[0].click();", careersPage.checkOpenings);
//        String checkConnectTitle = driver.getTitle();
//        System.out.println("checkConnectTitle = " + checkConnectTitle);
        driver.close();

    }

}
