package com.library.pages;

import com.library.utility.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class  BasePage {
    public BasePage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//span[normalize-space()='Dashboard']")
    public WebElement dashboardBtn;
    @FindBy(xpath = "//span[normalize-space()='Users']")
    public WebElement usersBtn;
    @FindBy(xpath = "//span[normalize-space()='Books']")
    public WebElement booksBtn;
    @FindBy(xpath = "//span[normalize-space()='Borrowing Books']")
    public WebElement borrowingBooks;

    public void navigateTo(String pageName){
        Driver.getDriver().findElement(By.xpath("//span[normalize-space()='"+pageName+"']")).click();

    }






}
