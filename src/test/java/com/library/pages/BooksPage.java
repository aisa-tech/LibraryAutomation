package com.library.pages;

import com.library.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BooksPage {

    public BooksPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//select[@id='book_categories']")
    public WebElement bookCategoriesDropDown;

    @FindBy(xpath = "//input[@type='search']")
    public WebElement searchBtn;

    @FindBy(xpath = "//select[@name='tbl_books_length']")
    public WebElement recordDropDown;

    @FindBy(xpath = "(//tbody//td[1]//a[@class='btn btn-primary btn-sm  '])[1]")
    public WebElement borrowBookBtn;











}
