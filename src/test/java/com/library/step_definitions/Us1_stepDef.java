package com.library.step_definitions;

import com.library.pages.LoginPage;
import com.library.utility.BrowserUtil;
import com.library.utility.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class Us1_stepDef {
    LoginPage loginPage = new LoginPage();

    @Given("Establish the database connection")
    public void establishTheDatabaseConnection() {
        DB_Util.createConnection();
    }

    @When("Execute query to get all IDs from users Then verify all users has unique ID")
    public void executeQueryToGetAllIDsFromUsersThenVerifyAllUsersHasUniqueID() {
        DB_Util.runQuery("SELECT id from users;");
        int expectedCount = DB_Util.getRowCount();
        DB_Util.runQuery("SELECT distinct(id )from users;");
        int actualCount = DB_Util.getRowCount();
        Assert.assertEquals(expectedCount,actualCount);


    }

    @When("Execute query to get all columns")
    public void executeQueryToGetAllColumns() {
        DB_Util.runQuery("Select * from users");

    }

    @Then("verify the below columns are listed in result")
    public void verifyTheBelowColumnsAreListedInResult(List<String>expected) {

        List<String>actual = DB_Util.getAllColumnNamesAsList();
        System.out.println(actual);
        Assert.assertEquals(expected,actual);

    }
}
