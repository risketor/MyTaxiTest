# MyTaxi Test for with Espresso

Project in Java with Espresso for a simple test in MyTaxiDemo app that: log in, search for a user and click on the phone button.

FILES
- MyTaxiTest.java - Test code.
- TestData.java - Specific class with the test data for the test, with valid login credentials the search details. 
- ActivityRule.java - Activity rule manager.


TEST SCENARIOS - what possible scenarios should be tested if the app has various kinds of users? 
CASE A. Assuming that username can belong to only one kind of users (passenger OR driver) at the same time:
- User registered as passenger, once logged in only sees passenger's section.
- User registered as driver, once logged in only sees driver's section.
- Once registered with a username with one of the kinds, it is not possible to register with the same username for the other kind.

CASE B. Assuming that username can belong to two kind of users (passenger AND driver) at the same time:
- User registered as passenger, once logged in only sees passenger's section.
- User registered as driver, once logged in only sees driver's section.
- User registered as passenger and driver, once logged in sees both sections: passenger's and driver's sections.
- Test that passenger user cannot book himself as driver if belongs to both kinds. 
Anyway same username for both kinds seems to complex and problematic. Keeping it simple, username should belong to only one kind. 

UX ISSUES / IMPROVEMENTS:
- Error messages should be displayed for: invalid username, username/password empty or wrong username/password when clicking on Login button.
- Forgotten username/password link should be added in Login page.
- Nice to have loading status while logging process, displaying the search results, logging out and loading driver profile.
- No protection system against cracking password (e.g: account temporary locked). 
- Welcome message when logging could be nice to have.
- Driver profile page, there should be a button to go back/up or logging out in the app.
- Search results not displayed on landscape mode (at least in my emulator).
 
NOTES:
- Laptop slow with Android Studio and emulator / internet connection quite slow. Therefore it wasn't too easy to write/test the code/app.
- Logger should have been added.
