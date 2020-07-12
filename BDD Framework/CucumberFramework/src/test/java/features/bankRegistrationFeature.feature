Feature: Resistration of a new user in the Bank

Scenario: User Registration

Given User is on Bank Registration Page
When User selects 1 option from title dropdown
When User enters his "<firstName>"
When User enters his "<lastName>"
When User selects his gender
When User enters his date of birth in "<MM/DD/YYYY>"
When User enters his unique "<SSN number>" in XXX-XX-XXXX format
When User enters his "<email address>"
When User enters his "<password>" of minimum 8 characters containing uppercase,lowercase characters and digits
When User enters his "<samePassword>" again in confirmation field
When User click on Next buttons
Then User lands on Registration Page 2
When User enters his "<address>"
When User enters his "<locality>"
When User enters his "<region>"
When User enters his valid "<zipcode>"
When User enters his "<countryName>"
When User enters his "<homePhoneNumber>"
When User enters his "<mobilePhoneNumber>"
When User enters his "<workPhoneNumber>"
When User Checks the terms & conditions checkbox
When User click on Register Button
Then User lands on the login screen with "<registrationSuccessMessage>"
 



