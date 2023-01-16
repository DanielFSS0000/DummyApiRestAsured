#Language en
Feature: Dummy API validating crud services

  Scenario: Dummy Api automation
    Given As a user I have the dummy apis that I want to validate
    When User verify the crud service of the apis
    Then receive a status 200