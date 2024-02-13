Feature: Language
  Language entities can be be initialised and store details

  Scenario: A film has an ID
    Given a film
    When I set the film's id to 201
    Then Film's id is 201