package com.library.step_definitions;

import com.library.pages.BooksPage;
import com.library.pages.LoginPage;
import com.library.utility.DB_Util;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.lang.invoke.CallSite;
import java.util.ArrayList;
import java.util.List;

public class Us3_stepDef {
    LoginPage loginPage = new LoginPage();
    BooksPage booksPage = new BooksPage();
    List<WebElement>categories;
    @Given("I login as a librarian")
    public void iLoginAsALibrarian() {
        loginPage.login("librarian");
    }
    @When("I navigate to {string} page")
    public void iNavigateToPage(String books) {
        loginPage.navigateTo(books);
    }
    @And("I take all book categories in UI")
    public void iTakeAllBookCategoriesInUI() {
        Select select = new Select(booksPage.bookCategoriesDropDown);
        categories = select.getOptions();
    }
    @And("I execute query to get book categories")
    public void iExecuteQueryToGetBookCategories() {
        DB_Util.createConnection();
        DB_Util.runQuery("select name from book_categories");

    }
    @Then("verify book categories must match book_categories table from db")
    public void verifyBookCategoriesMustMatchBook_categoriesTableFromDb() {

        List<String>expectedCategories = DB_Util.getColumnDataAsList(1);
        List<String>names = new ArrayList<>();
        for (WebElement each : categories) {
            names.add(each.getText());
        }
        names.remove(0);
        System.out.println(names);
        Assert.assertEquals(expectedCategories,names);

    }
}
