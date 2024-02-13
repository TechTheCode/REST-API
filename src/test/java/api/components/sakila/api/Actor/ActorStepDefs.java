package api.components.sakila.api.Actor;

import api.components.sakila.api.domain.Actor;
import api.components.sakila.api.service.ActorService;
import io.cucumber.java.en.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ActorStepDefs {
    Actor actor;

    //1st test
    @Given("an actor")
    public void anActor(){
        actor=new Actor();
    }

    @When("I set the actor's id to {short}")
    public void setActorID(short actorID) {
        actor.setActorID(actorID);
    }

    @Then("Actor's id is {short}")
    public void checkActorID(short actorID){
        assertEquals(actorID, actor.getActorID());
    }

    //2nd test
    @When("I set the actor's first name to {string}")
    public void setActorFirstName(String name){
        actor.setFirstName(name);
    }

    @Then("Actor's first name is {string}")
    public void checkActorFirstName(String name){
        assertEquals(name,actor.getFirstName());
    }
    /*
    Scenario: An actor has a first name
    Given an actor
    When I set the actor's first name to "Kevin"
    Then Actor's first name is "Kevin"
     */

    //3rd test
    @When("I set the actor's last name to {string}")
    public void setActorLastName(String name){
        actor.setLastName(name);
    }

    @Then("Actor's last name is {string}")
    public void checkActorLastName(String name){
        assertEquals(name,actor.getLastName());
    }
}
