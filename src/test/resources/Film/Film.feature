Feature: Film
  Film entities can be be initialised and store details

  Scenario: A film has an ID
    Given a film
    When I set the film's id to 201
    Then Film's id is 201

  Scenario: Retrieve films by category
    Given I am connected to the test database
    When I query for films in category with ID 1
    Then I should get a list of films for that category