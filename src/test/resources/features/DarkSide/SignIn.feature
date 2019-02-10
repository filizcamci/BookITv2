Feature: User should be able to login as different users 
Scenario Outline: 1 Login as a student to the dark side 
    Given I am on reservation landing page 
    When I login as a student with "<email>" and "<password>"
    Then I should be able to logout 
    
    Examples: 
        | email                | password     |
        | jhelkin7u@hao123.com | stantonmatus |
    
@ignore 
Scenario: 2 Login as a student to the dark side 
    Given I am on reservation landing page 
    When I login as a student to the dark side 
    Then I should be able to logout 
    
@ignore 
Scenario Outline: 3 Login as a different role 
    Given I am on Reservation landing page 
    When I login as a student "<username>", "<password>" to the light side 
    Then I should be able to logout 
    
    Examples: 
        | username     | password         |
        | teamleadmail | teamleadpassword |
        | studentemail | studentpassword  |
        | teacheremail | teacherpassword  |
        
        
