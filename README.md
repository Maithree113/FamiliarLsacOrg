# Familiar Lsac

How to run the setup?

Clone the git repo using https Build the project using maven build command "clean install" Once the build is success Navigate to runner folder Select LsacRunner runner Right click on them and say run As TestNg. You are all set Reports will be generated in target folder under cucumber-reportsUI

Automated UI Testcases : Written in BDD format is present in features/lsachomepage.feature

Tools Used to Automate

IDE : Eclipse

Selenium webdriver : UI Automation

Cucumber : BDD (Testcases)

Extent Report : Generate User friendly reports

Design Approach

POM : UI Automation

BDD : UI

Browser : Safari and Chrome mobile web browser and chrome web browser

Properties file : It can be set to mobile or web based on that testcases will be run on browser or on mobile browser

Runner Files

To run the feature file runner file is added under cucumberRunner folder

UI Runner : CucumberRunner/LsacRunner.java

     : Right click on LsacRunner.java and run as TestNg   
	
     : By default it will run all 2 scenarios   
See Reports

Reports are generated under target folder

UI Report : Backbase_Assignment/target/cucumber-reportsUI/report.html
