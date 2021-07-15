

Feature: As a user I should enter the card details and add card for payments


   Background:
         Given I navigate to "https://pay-sandbox.hokodo.co/?design=default&order=order-eBw6yZkyBqLnLqxBZCe2Zf&plan=ppln-9vJYMAABHWKi7i6nfGouL3&key=pe90jPY2PhcUi9HXHpzwcEy5RCNRhXSTPIzkGAhDabk&template=pptemp-H5SMNDpBpVtT7ZYqAPDntf"
       
 @tag1
  Scenario: validate error message for invaid card details
  
    And click on "Debit/Credit Card" under payment Authorisation
    And enter invalid card details
         | cardholders name | test                |
         | Card             | 1111 1111 1111 1111 |
        
    Then error message saying invalid card details must be displayed
    
  @tag1  
  Scenario: validate card details are added succesfully
  
    
    And click on "Debit/Credit Card" under payment Authorisation
    And enter valid card details
         | cardholders name      | test                |
         | Card                  | 4111 1111 1111 1111 |
         | CardExpiry            | 12/24               |
         | CVCNumber             | 123                 |
         | Line1            		 | 87 Badlis Road      | 
         | Line2                 | yyy                 |
         | City/Town             | London              |
         | State/Province/Region | London              |
         | Postal/ZipCode        |  E17 5LG            | 
         | Country               |  United Kingdon     |
    Then card added succesfully message should be displayed
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    