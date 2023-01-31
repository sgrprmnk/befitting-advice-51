# Hoodie Foodie (Online Food Delivery System)
<img src="https://github.com/sgrprmnk/befitting-advice-51/blob/main/ProjectLogo.PNG">
<h2> Online Food Delivery App strictly followed MVC architecture </h2>

 - We have developed this REST API for an Ecommarce Rest API. This API performs all the fundamental CRUD operations of any ecommarce Application platform with user validation at every step.
 
 ## Team Members
 
 <a href="https://github.com/sgrprmnk">Sagar Pramanik</a>
 <br>
 <a href="https://github.com/Sandeepyadav14">Sandeep Yadav</a>
 <br>
 <a href="https://github.com/Swapnil28Y">Swapnil Yeutkar</a>
 <br>
 <a href="https://github.com/Akash-298">Akash Chikhalonde</a>

## Module
<img src="https://github.com/sgrprmnk/befitting-advice-51/blob/main/model.png">



## Entity Relationship Diagram

<img src="https://github.com/sgrprmnk/befitting-advice-51/blob/main/Picture1.png">


## Functionality (Swagger UI) 
<a href="https://github.com/sgrprmnk/befitting-advice-51/blob/main/Hoodie_Foodie_ui.pdf">Click Here for functionality details</a>
## Functionality at a glance
-   User can register/login-logout
-   can view all items
-   can view restaurants
-   Find items by category
-   Add to cart/edit into the cart
-   Place Order
-   Get orderdetails
-   Calculate Bills
<img src="https://github.com/sgrprmnk/befitting-advice-51/blob/main/functionalityAtGlance.png">

## REST API
<a href="https://github.com/sgrprmnk/befitting-advice-51/blob/main/Hoodie_Foodie_api.pdf">Click Here for api details</a>

## Backend Work
-  Proper Exception Handling
-  Proper Input Validation
-  Data Stored in the database(mySQL)
-  User Authentication of signUp, Login and Logout

## Installation and Run
-  You can clone this repo and start the serve on localhost
-   Before running the API server, we should update the database config inside the application.properties file.
-   Update the port number, username and password as per our local database config.
    -   server.port=8888
    -   spring.datasource.url=jdbc:mysql://localhost:3306/emcommarcedb
    -   spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    -   spring.datasource.username=**Your UserName**
    -   spring.datasource.password=**YourPassword**
    -   spring.jpa.hibernate.ddl-auto=update
    -   spring.jpa.show-sql=true
    -   spring.mvc.pathmatch.matching-strategy = ANT_PATH_MATCHER
    
-to check the swagger http://localhost:8888/swagger-ui/

## Tech Stacks
<p>
   <img src="https://img.icons8.com/color/64/000000/java.png"/>
   <img src="https://img.icons8.com/color/48/null/spring-logo.png"/>
   <img src="https://github.com/efat56/striped-pear-8171/blob/main/Images/hibernate_logo_icon_171004.png" />
   <img src="https://img.icons8.com/ios/50/null/mysql-logo.png"/>
</p>

-   Java Core
-   Spring Boot
-   Spring Data JPA
-   JPQL
-   MySQL
-   Hibernate
-   Swagger
-   Lombok

## Unique Features
- Used Id as a String and unique in every cases
- Can be Multilanguage(Regional Language)




