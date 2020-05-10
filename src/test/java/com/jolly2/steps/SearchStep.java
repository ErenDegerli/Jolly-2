package com.jolly2.steps;

import com.jolly2.pages.HomePage;
import com.jolly2.pages.ReservationHelper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import java.io.IOException;

public class SearchStep {

    private WebDriver driver;
    private HomePage homePage;
    private ReservationHelper reservationHelper;

    public SearchStep() {
        driver = StepHooks.driver;
        homePage = new HomePage(driver);
        reservationHelper = new ReservationHelper(driver);
    }

    @Given("User is on the HomePage")
    public void user_is_on_the_HomePage() throws IOException {
        homePage.getHomePage();
    }

    @When("User makes a search for a reservation to {string} from {string} to {string} for {string} adult and {string} children")
    public void user_makes_a_search_for_a_reservation_to_from_to_for_adult_and_children(String city, String departTime, String returnTime, String adultNumber, String childrenNumber) throws IOException, InterruptedException {
        reservationHelper.makeSearch(city,departTime,returnTime,adultNumber,childrenNumber);
    }

    @Then("User should see {string} on HomePage")
    public void user_should_see_on_HomePage(String msg) {
        Assert.assertTrue(homePage.checkMsg(msg));
    }
}