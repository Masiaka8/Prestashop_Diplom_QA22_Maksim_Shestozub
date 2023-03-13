### Prestashop_Diplon_QA22_Maksim_Shestozub

The site was tested in this project http://prestashop.qatestlab.com.ua/ru/

Prestashop is a test site an online clothing store.

#### Checklist:
1. Authorization test (LogIn, LogOut, Negative)
2. Test to registration users (Positive, Negative)
3. Test to add delivery address
4. Cart test (add/delete test)
5. Filter test
6. Search test (Positive, Negative)
7. Sorting test 
8. Test to add item in wishlist

#### Tools/ Liabraries/ Frameworks used:
1. IDE: IntelliJ IDEA
2. Programming Language: JAVA
3. Project Type: Maven
4. Selenium-java 3.141.59
5. TestNG 7.4.0
6. Allure-testng 2.18.1
7. Lombok 1.18.24
8. log4j-core 2.19.0
9. Jenkins
10. Javafaker 1.0.2
11. Test listener
12. Retry Analyzer
13. GitHub

#### Running tests:
1. TestNG command for run: - mvn clean test
2. Running Specific Tests and Methods:
> - mvn clean test -DsuiteXmlFile="smokeTest.xml"
> - mvn clean test -DsuiteXmlFile="regressionTest.xml" 
> - mvn clean test -DsuiteXmlFile="negativeTest.xml"
3. Command to run tests from one class: 
> mvn clean test -Dtest="LoginTest"
4. Command to run one test from a class: 
> mvn clean test -Dtest="LoginTest#positiveLoginTest"
5. Allure command for run: 
> - mvn allure:serve 
> - mvn allure:report
6. Jenkins




