package com.library.step_definitions;

import com.library.pages.BooksPage;
import com.library.pages.BorrowingBooksPage;
import com.library.pages.LoginPage;
import com.library.utility.BrowserUtil;
import com.library.utility.DB_Util;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

public class us7_stepD {
    LoginPage loginPage = new LoginPage();
    BooksPage booksPage = new BooksPage();
    BorrowingBooksPage borrowingBooksPage = new BorrowingBooksPage();
    String borrowedBookName;

    @Given("I login as a student")
    public void iLoginAsAStudent() {
        loginPage.login("student");
    }

    @And("I search book name called {string}")
    public void iSearchBookNameCalled(String bookName) {
        booksPage.searchBtn.sendKeys(bookName);
        BrowserUtil.waitFor(5);
        borrowedBookName = bookName;
    }

    @When("I click Borrow Book")
    public void iClickBorrowBook() {
        Select select = new Select(booksPage.recordDropDown);
        select.selectByVisibleText("500");
        BrowserUtil.waitForVisibility(booksPage.borrowBookBtn,5);
        booksPage.borrowBookBtn.click();
    }
    @Then("verify that book is shown in Borrowing Books page")
    public void verifyThatBookIsShownInBorrowingBooksPage()  {
        BrowserUtil.waitFor(2);
        loginPage.navigateTo("Borrowing Books");
        BrowserUtil.waitFor(2);
        List<String>bookNames = new ArrayList<>();
        for (WebElement each : borrowingBooksPage.bookName) {
            bookNames.add( each.getText());
        }
        Assert.assertTrue(bookNames.contains(borrowedBookName));
    }

    @And("verify logged student has same book in database")
    public void verifyLoggedStudentHasSameBookInDatabase() {
        DB_Util.createConnection();
        DB_Util.runQuery("select name  from books right join book_borrow on books.id = book_borrow.book_id ;");
        List<String>borrowedBooksDB = DB_Util.getColumnDataAsList(1);
        Assert.assertTrue(borrowedBooksDB.contains(borrowedBookName));
        System.out.println(borrowedBooksDB);

    }
    }
