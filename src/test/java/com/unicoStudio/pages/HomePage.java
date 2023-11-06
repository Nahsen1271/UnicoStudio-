package com.unicoStudio.pages;


import com.unicoStudio.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    public HomePage() {

        PageFactory.initElements(Driver.get(), this);
    }



    @FindBy (xpath= "//img[@alt='unicotext']")
    public WebElement unicotext;

    @FindBy(xpath="//a[normalize-space()='About']")
    public WebElement aboutBtn;

    @FindBy(xpath="//ul/li/a[@href='about.html']")
    public WebElement aboutBtn2;

    @FindBy(xpath="//a[@class='btn-alt-shadow-rounded-large hover-gray px-4 p-2']")
    public WebElement learnAboutUs;

    @FindBy(xpath = "//*[@id='navbar']/ul/li[1]/a") //
    public WebElement ageOfBrainosBtn;
    @FindBy(xpath = "//a[normalize-space()='Careers']") // //*[@id="navbar"]/ul/li[1]/a
    public WebElement careersBtn;

    @FindBy(xpath = "//a[normalize-space()='Games']")
    public WebElement gamesBtn;

    @FindBy(xpath="//a[normalize-space()='Contact']")
    public WebElement contactBtn;

    @FindBy(xpath ="//a[normalize-space()='Google Play']")
    public WebElement googlePlayBtn;


    @FindBy(xpath = "//a[normalize-space()='App Store']")
    public WebElement appStoreBtn;


    @FindBy (xpath= "//i[@class='bx bxl-twitter']")
    public WebElement twitterBtn;

    @FindBy(xpath="//i[@class='bx bxl-facebook']")
    public WebElement facebookBtn;

    @FindBy(xpath = "//i[@class='bx bxl-instagram']")
    public WebElement instagramBtn;

    @FindBy(xpath="//i[@class='bx bxl-linkedin']")
    public WebElement linkedinBtn;

    @FindBy(xpath="//a[normalize-space()='Terms & Conditions']")
    public WebElement termAndCon;

    @FindBy(xpath="//h1[@id='terms-and-conditions']")
    public WebElement termAndConText; //  mc-closeModal

    @FindBy(className = "mc-closeModal")
    public WebElement closePopUp;

    @FindBy(xpath="//a[normalize-space()='Privacy Policy']")
    public WebElement privacyPolicy;

    @FindBy(xpath="//h1[@id='privacy-policy']")
    public WebElement privacyPolicyText;

    @FindBy(xpath="//a[normalize-space()='Age of Brainos']")
    public WebElement ageOfBrainos;




    //i[@class='bx bxl-twitter']
    //i[@class='bx bxl-facebook']
    //i[@class='bx bxl-instagram']
    //i[@class='bx bxl-linkedin']





}
