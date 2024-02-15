Feature: Category
  Category entities can be be initialised and store details

  Scenario: Retrieve films by category
    Given I am connected to the test database
    When I query for films in category with ID 1
    Then I should get a list of films for that category