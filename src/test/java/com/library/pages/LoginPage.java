package com.library.pages;

import com.library.utility.ConfigurationReader;
import com.library.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{
    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }



    @FindBy(id = "inputEmail")
    public WebElement email;

    @FindBy(id = "inputPassword")
    public WebElement password;

    @FindBy(tagName = "button")
    public WebElement signInBtn;

    public void login(String userType){
        String username = ConfigurationReader.getProperty(userType +"_username");
        String password = ConfigurationReader.getProperty(userType+"_password");
        email.sendKeys(username);
        this.password.sendKeys(password);
        signInBtn.click();
    }

}
