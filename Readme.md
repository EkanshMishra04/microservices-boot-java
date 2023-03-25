# Microservices Assignment 
## Author 
    Ekansh mishra

## Description
    This project is MVP for a banking application made with keeping microservice architecture in mind.Details of these microservices are mentioned below :
    
#### 1.	Customer Management Service with below mentioned APIs:
        a.	Add customer
        b.	Get all Customers
        c.	Get single Customer Details
        d.	Update Customer Details
        e.	Delete Customer (Deleting customer should also delete the customer account from account management service)
#### 2.	Account Management service with below mentioned APIs:
        a.	Add Money to account. (Before adding money to account must check if customer details passed in the request are valid or not)
        b.	Withdraw money from account. (Before adding money to account must check if customer details passed in the request are valid or not)
        c.	Get Account details. (Details include account details and related customer details).
        d.	Delete Account.
#### 3. Other Requirements:
        a. Api Gateway Service for as gateway provides a single endpoint or URL for the client apps and then internally maps the requests to a group of internal microservices.

        b. Eureka Server used for every Micro service will register into the Eureka server and Eureka server knows all the client applications running on each port and IP address. Eureka Server is also known as Discovery Server.

        c. Centralized Configuration Management as looks up the configuration and provides the configuration to the microservices.
#### 4. What has been used and where:
        a. Use of Rest templete:
            It has been used for inter-service communication like used in customer service to create an account of that user and similarly in account service to fetch the customer details for the requested bank account user.

        b. what cofigurations have been centralized: 
            Common confiurations of spring datasource and jpa has been centralized. Along with two of the most common error messages and eureka instance hostname.
            Config repo folder contains application.yml file where configuration server service looks up for configurations to provide to other service [Pushed to local git repo for look up purpose].
        
        c. software requirement:
            Java Jdk 11
            SPring version used 2.7.8
            Eclipse for web and java developers 2022-06 version
            Mysql for database with a database schema named 'BANK'
        
        d. API EndPoints in API ENDPOINTS.txt file

        e. Exception Handling:
            Custom Exception class of Resource not found has been used which extends RuntimeException.

        f. Http Status codes:
            Various Http status codes has been used like NOT_FOUND, NOT_MODIFIED, BAD_REQUEST, OK.

## How to Run the project

    a. Order in which services should be started:
        Run Eureka Server which will run on port [8761]
        RUN Centralized configuration which will run on port [8888]
        RUN Account Service which will run on port [9002]
        RUN Customer Service which will run on port [9001]
        RUN API gateway which will run on port [8999]
    
    b. Please ensure that none of the port is prerunning or engaged in other service.

    c. End points description has been provided in EndPointsDemo.txt file. Please refer to know various end points in each of the service.

    d. Use Postman service to access all end point url.


## License
    This project is part of my bench training program under Nagarro software lmt and is property of Nagarro [IT service management company].

### For further query contact me ekansh.mishra@nagarro.com