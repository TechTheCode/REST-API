Feature: Inventory
  Inventory entities can be be initialised and store details

  Scenario: A store has an inventory
    Given a film
    When I set the film's id to 201
    Then Film's id is 201