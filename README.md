# cucumber
Sample Project
Cucumber Playground

# General Notes
The test set up has been done on a Windows machine. 
You may need to change the system path in the Hooks.java class 
if you are using Mac. Also, you should download a Chromedriver 
for mac binary and place it in the src/test/java/resources/drivers folder.

# How to run the tests:

mvn clean test

Or via the IDE >> go to the feature file >> Run As >> Cucumber Feature (you should have the cucumber plugin installed first). 
You can also add cucumber.api.cli.Main parameter to the run configuration of your IDE

If you wish to specify which tags to run using maven, you can do:

Mvn clean test –Dcucumber.options=”—tags @calculator”
