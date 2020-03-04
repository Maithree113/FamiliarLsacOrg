Feature: Validate Calculator operations

@Subtraction @UI
Scenario Outline: Subtraction operation with two positive number
Given i have a online calculator app
And first  number is "<num1>"
When i click on "<operation>" 
And second number is "<num2>"
Then result is as per expected "<img>"

Examples:
   |operation|num1   |num2     |img        |
   |minus    | 9     | 7       |9-7.PNG    |
   |minus    | 77    |88       |77-88.PNG  |
   |minus    |8888   |99999    |888-999.PNG|
   |minus    |1000000|999999999|4sub.PNG   |
   |minus    |99.999 |100.998  |5sub.PNG   |
   
@Subtraction @UI
Scenario Outline: Subtraction operation with negative number
Given i have a online calculator app
And first  number is "<num1>"
When i click on "<operation>" 
And second number is "<num2>"
Then result is as per expected "<img>"

Examples:
   |operation|num1   |num2      |img      |
   |minus    | -9    | 9        |6sub.PNG |
   |minus    | 77    |-88       |7sub.PNG |
   |minus    |-8888  |99999     |8sub.PNG |
   |minus    |1000000|-999999999|9sub.PNG |
   |minus    |99.999 |-100.998  |10sub.PNG| 
   
@Division @UI
Scenario Outline: Division operation with negative number
Given i have a online calculator app
And first  number is "<num1>"
When i click on "<operation>" 
And second number is "<num2>"
Then result is as per expected "<img>"

Examples:
   |operation   |num1    |num2      |img     |
   |division    | -9     | 9        |div1.PNG|
   |division    | 77     |-88       |div2.PNG|
   |division    |-8888   |99999     |div3.PNG|
   |division    |-1000000|999999999 |div4.PNG|
   |division    |99.999  |-100.998  |div5.PNG|     

@Division @UI
Scenario Outline: Division operation with positive number
Given i have a online calculator app
And first  number is "<num1>"
When i click on "<operation>" 
And second number is "<num2>"
Then result is as per expected "<img>"

Examples:
   |operation   |num1   |num2      |img      |
   |division    | 9     | 7        |div6.PNG |
   |division    | 77    | 88       |div7.PNG |
   |division    | 8888  |99999     |div8.PNG |
   |division    |1000000| 999999999|div9.PNG |
   |division    |99.999 | 100.998  |div10.PNG|

@Clear @UI
Scenario Outline: Click on clear(CE) operation without entering any number
Given i have a online calculator app
When i click on "<operation>" 
Then everything should get cleared "<img>"

Examples:
   |operation   |img     |
   |clear       |clr1.PNG|
       

@Clear @UI
Scenario Outline: Click on clear(CE) operation without entering number
Given i have a online calculator app
And first  number is "<num1>"
When i click on "<operation>" 
Then everything should get cleared "<img>"

Examples:
   |operation   |num1          |img     |
   |division    | 999999999    |clr1.PNG|

@Clear @UI
Scenario Outline: Division operation with positive number
Given i have a online calculator app
And first  number is "<num1>"
When i click on "<operation>" 
And second number is "<num2>"
And i click on "<operation1>" 
Then everything should get cleared "<img>"

Examples:
   |operation   |num1   |num2      |operation1|img     |
   |division    | -9    | 9        |clear     |clr1.PNG|
   |division    | 77    |-88       |clear     |clr1.PNG|
  

@Clear @UI
Scenario Outline: Clear after performing operation
Given i have a online calculator app
And first  number is "<num1>"
When i click on "<operation>" 
And second number is "<num2>"
Then result is as per expected "<img1>"
And i click on "<operation1>" 
And everything should get cleared "<img>"

Examples:
   |operation   |num1   |num2      |operation1|img     |img1    |
   |division    | 8888  | 99999    |clear     |clr1.PNG|div8.PNG|
   |minus       | 77    |-88       |clear     |clr1.PNG|7sub.PNG|