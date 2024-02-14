package api.components.sakila.api.Film;

import api.components.sakila.api.domain.Film;
import api.components.sakila.api.repositories.FilmRepository;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class FilmStepDefs {
    /*
    Scenario: Retrieve films by category
    Given I am connected to the test database
    When I query for films in category with ID 1
    Then I should get a list of films for that category

     */
    @Autowired
    private FilmRepository filmRepository;

    private List<Film> retrievedFilms;

    @Given("I am connected to the test database")
    public void data() {
    }

    @When("I query for films in category with ID {int}")
    public void filmCategory(Integer categoryId) {
        retrievedFilms = filmRepository.findFilmsByCategoryId(categoryId.longValue());
    }

    @Then("I should get a list of films for that category")
    public void filmCategoryCheck() {
        Assert.assertFalse("Film list should not be empty", retrievedFilms.isEmpty());
    }

}