Feature: RecyclingFactory

  Scenario: Installation of process in recycling factory
    Given I have a recycling factory with a conveyor
    When I install separation processes
    Then The conveyor should have all the separation processes i have installed

  Scenario: Installation of sensors in each box
    Given I have a recycling factory with a conveyor
    When I install Sensors
    Then Box of each separation process of the conveyor should have a sensor

  Scenario: Paper filled boxes in factory
    Given I have a recycling factory with a conveyor
    And I have a control room with all the information about processes of the conveyor and a factory worker in the control room
    When I install separation processes
    And I install Sensors
    And I generate 5001 paper recyclables
    And I start the conveyor
    Then There should be 5 number of filled bags in the factory containing only papers

  Scenario: testing sensor alarms
    Given I have a recycling factory with a conveyor
    And I have a control room with all the information about processes of the conveyor and a factory worker in the control room
    When I install separation processes
    And I install Sensors
    And I generate 3001 paper recyclables
    Then The sensor of the paper separation box should setAlarm 3 times

  Scenario: Recyclables of specific type are separated by the process responsible for it
    Given I have a recycling factory with a conveyor
    And I have a control room with all the information about processes of the conveyor and a factory worker in the control room
    When I install separation processes
    And I install Sensors
    And I generate 500 random recyclables
    And I start the conveyor
    Then Each process should separate recyclables that they are responsible for
