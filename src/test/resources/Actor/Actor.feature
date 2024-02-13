Feature: Actors
  Actor entities can be be initialised and store details

  Scenario: An actor has an ID
    Given an actor
    When I set the actor's id to 201
    Then Actor's id is 201

  Scenario: An actor has a first name
    Given an actor
    When I set the actor's first name to "Kevin"
    Then Actor's first name is "Kevin"

  Scenario: An actor has a last name
    Given an actor
    When I set the actor's last name to "Pham"
    Then Actor's last name is "Pham"