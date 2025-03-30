# one-rmm-test

Ninja-One
Automation tests created for the NinjaOneRMM login page.

Automation Testing Framework used : Selenium Webdriver with TestNG Maven project is created for NinjaRMM project

Two tests are created: 
LoginPageElementsTest - Validates all the page elements for the NinjaRMM login page 
LoginTest - Login to the NinjaRMM with user and password and OTP code.

Pom.xml files includes the maven dependencies

Source file: /ninjarmm/src/test/java/Base /ninjarmm/src/test/java/testcases /ninjarmm/src/test/java/utilities

Config files: /ninjarmm/src/test/resources/configfiles/locators.properties /ninjarmm/src/test/resources/configfiles/config.properties

Runner file: /ninjarmm/testrunner/testng.xml

Results: /ninjarmm/test-output/index.html

Github  branch: chromeoptions: updated tests with the chrome headless browser options.

Github Actions: Created the main.yml and updated the steps.
Tests run successfully for the two tests.
