package com.techproed.pages;

import com.techproed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.security.PublicKey;

public class AmazonLoginPage {

    public AmazonLoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//span[@class='nav-line-2 ']")
    public WebElement signIn;

    @FindBy(id = "createAccountSubmit")
    public WebElement createButton;

    @FindBy(id="ap_customer_name")
    public WebElement yourname;

    @FindBy(id="ap_email")
    public WebElement email;

    @FindBy(id="ap_password")
    public WebElement password;

    @FindBy(id="ap_password_check")
    public WebElement repassword;

    @FindBy(id="continue")
    public WebElement createAccountButton;


}
