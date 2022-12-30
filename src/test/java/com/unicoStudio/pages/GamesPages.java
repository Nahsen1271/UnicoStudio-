package com.unicoStudio.pages;

import com.unicoStudio.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GamesPages {

    public GamesPages() {

        PageFactory.initElements(Driver.get(), this);
    }
    @FindBy(xpath= "//h2[normalize-space()='Unico Studio']")
    public WebElement unicoStudio;

    @FindBy(xpath="//h2[@class='font-impact text-black'][normalize-space()='Brain Test']")
    public WebElement brainTest;//div[@class='col-12 col-md-4 order-2 order-lg-1']//div[@class='col-4']//i[@class='bx bxl-play-store']

    @FindBy(xpath="//div[@class='col-12 col-md-4 order-2 order-lg-1']//div[@class='col-4']//i[@class='bx bxl-play-store']")
    public WebElement brainTestGP;
//div[@class='col-12 col-md-4 order-2 order-lg-1']//i[@class='bx bxl-apple']

    @FindBy(xpath="//div[@class='col-12 col-md-4 order-2 order-lg-1']//i[@class='bx bxl-apple']")
    public WebElement brainTestAppSore;

    @FindBy(xpath="//h1[@class='product-header__title app-header__title']")
    public WebElement brainTestAppText;



    @FindBy(xpath="//div[@class='col-12 col-md-4 order-2 order-lg-1']//img")
    public WebElement brainTestPoki;


    @FindBy(xpath = "//h2[@class='font-impact text-black'][normalize-space()='Who Is?']")
    public WebElement whoIs;

    @FindBy(xpath = "//h2[normalize-space()='Wordfest']")
    public WebElement wordFest;

    @FindBy(xpath="//h2[@class='font-impact text-black'][normalize-space()='Life Choices']")
    public WebElement lifeChoices;

    @FindBy(xpath ="//a[@class='btn-shadow-rounded-large hover-gray px-4 p-2']")
    public WebElement checkOpenPosition;

    @FindBy(xpath ="//a[normalize-space()='Google Play']")
    public WebElement googlePlayAboutBtn;

    @FindBy(xpath = "//a[normalize-space()='App Store']")
    public WebElement appStoreAboutBtn;


    //    //a[normalize-space()='Google Play']---Use AboutpageGooglePlay
    //    //a[normalize-space()='App Store']  ---Use AboutpageAppStore
    //    //i[@class='bx bxl-twitter']--UseHomePageTw
    //    //i[@class='bx bxl-facebook'] --""
    //    //i[@class='bx bxl-instagram']--""
    //    //i[@class='bx bxl-linkedin']-- ""
}
