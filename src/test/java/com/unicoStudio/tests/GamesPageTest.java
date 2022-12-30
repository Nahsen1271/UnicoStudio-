package com.unicoStudio.tests;

import com.unicoStudio.pages.AboutPage;
import com.unicoStudio.pages.GamesPages;
import com.unicoStudio.pages.HomePage;
import com.unicoStudio.utilities.BrowserUtils;
import com.unicoStudio.utilities.ConfigurationReader;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

public class GamesPageTest  extends TestBase{

    HomePage homePage=new HomePage();
    AboutPage aboutPage=new AboutPage();
    GamesPages gamesPages=new GamesPages();
    JavascriptExecutor jse;

    String homeWindow;
    Set<String> windowHandles;
    Iterator t;
    @Test(priority = 1)
    public void gamesPageTest() {
     //   jse= (JavascriptExecutor) driver;
    //    jse.executeScript("arguments[0].click();",homePage.gamesBtn);
        homePage.gamesBtn.click();
        String actUnicoStudioText = gamesPages.unicoStudio.getText();
        System.out.println("actUnicoStudioText = " + actUnicoStudioText);
        Assert.assertEquals(actUnicoStudioText,ConfigurationReader.get("expUnicoStudioText"));
        
        String actGamesPageTitle = driver.getTitle();
        System.out.println("actGamesPageTitle = " + actGamesPageTitle);
        Assert.assertEquals(actGamesPageTitle,ConfigurationReader.get("expGamesPageTitle"));



    }
    @Test(priority = 2) /* Brain Test Google Play Check*/
    public void brainTestGP() {
        jse= (JavascriptExecutor) driver;
      //  jse.executeScript("arguments[0].click();",homePage.gamesBtn);
        homePage.gamesBtn.click();
        String brainTestText = gamesPages.brainTest.getText(); // Verify that it is Brain Test Game
        System.out.println("brainTestText = " + brainTestText);

        Assert.assertEquals(driver.getTitle(),ConfigurationReader.get("expGamesPageTitle"));

        homeWindow=driver.getWindowHandle();
        System.out.println("homeWindow = " + homeWindow);

        // Google Play sayfasına geçişin kontrol edilmesi

        jse.executeScript("arguments[0].click();",gamesPages.brainTestGP);
       // gamesPages.brainTestGP.click();
        windowHandles = driver.getWindowHandles();
        t = windowHandles.iterator();
        String mainPage  = (String) t.next();
        String newWindow= (String) t.next();
        driver.switchTo().window(newWindow);
        BrowserUtils.waitForPageToLoad(1);
        BrowserUtils.waitFor(1);
        String actGPGamesTitle=driver.getTitle();
        Assert.assertEquals(actGPGamesTitle, ConfigurationReader.get("expGPGamesTitle"));// Assert burada yapılacak.




    }
    @Test(priority = 3) /* Brain Test AppStore Check*/
    public void brainTestAppStore() {
        jse= (JavascriptExecutor) driver;
      //  jse.executeScript("arguments[0].click();",homePage.gamesBtn);
        homePage.gamesBtn.click();
       jse.executeScript("arguments[0].click();",gamesPages.brainTestAppSore);
        windowHandles = driver.getWindowHandles();
        t = windowHandles.iterator();
        String mainPage  = (String) t.next();
        String newWindow= (String) t.next();
        driver.switchTo().window(newWindow);
        BrowserUtils.waitForPageToLoad(1);
        BrowserUtils.waitFor(1);
        Assert.assertEquals(gamesPages.brainTestAppText.getText(), ConfigurationReader.get("expBTAppStore"));// Assert burada yapılacak.




    }
    @Test(priority = 4)  /* Brain Test Poki Check*/
    public void brainTestPoki() {
        jse= (JavascriptExecutor) driver;
        homePage.gamesBtn.click();
        jse.executeScript("arguments[0].click();",gamesPages.brainTestPoki);
        windowHandles = driver.getWindowHandles();
        t = windowHandles.iterator();
        String mainPage  = (String) t.next();
        String newWindow= (String) t.next();
        driver.switchTo().window(newWindow);
        BrowserUtils.waitForPageToLoad(1);
        BrowserUtils.waitFor(1);
        String poki= driver.getTitle();
        System.out.println("poki = " + poki);
        Assert.assertTrue(poki.contains("Poki"));// Assert burada yapılacak.


    }
    /*Bundan sonra aynı patern diğer oyunlarında kontrolü yapılabilir..*/



}
