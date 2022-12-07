package com.library.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class US6_stepDef {
    @When("the librarian click to add book")
    public void theLibrarianClickToAddBook() {
    }

    @And("the librarian enter book name {string}")
    public void theLibrarianEnterBookName(String arg0) {
    }

    @When("the librarian enter ISBN {string}")
    public void theLibrarianEnterISBN(String arg0) {
    }

    @And("the librarian enter year {string}")
    public void theLibrarianEnterYear(String arg0) {
    }

    @When("the librarian enter author {string}")
    public void theLibrarianEnterAuthor(String arg0) {
    }

    @And("the librarian choose the book category {string}")
    public void theLibrarianChooseTheBookCategory(String arg0) {
    }

    @And("the librarian click to save changes")
    public void theLibrarianClickToSaveChanges() {
    }

    @Then("the librarian verify new book by {string}")
    public void theLibrarianVerifyNewBookBy(String arg0) {
    }

    @Then("the librarian verify new book from database by {string}")
    public void theLibrarianVerifyNewBookFromDatabaseBy(String arg0) {
    }
}
