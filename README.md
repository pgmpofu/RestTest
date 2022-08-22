# RestTest Application

## Overview
This application was created as part of the interview process at Bench Labs.

This application does the following:
- connects to a REST API and fetches all pages of financial transactions.
- calculates total transaction amounts per day and prints it to the console, this is the sum of all amounts in all transactions of each day. For example, if I have 3 transactions on 2021-03-03 each for $4, then the total daily transaction amount for 2021-03-03 would be $12.
- calculates a running daily balance over many days and prints them to the console. For example, if I have 3 transactions for the 5th 6th 7th, each for $5, then the running daily balance on the 4th would be $0, on the 5th would be $5, on the 6th would be $10, on the 7th it would be $15. Or in more technical terms: calculate a cumulative sum over total daily balances. For example, given the following transactions:

## Development Environment
The following tools and technologies were used to develop this application:

- Spring Boot 2.7.3
- Java 17 
- MySQL 8.0.30
- Hibernate
- IntelliJ IDEA 2022.2 (Community Edition)

## Running the application
You can either: 
- Navigate into the folder via the terminal and type `./gradlew bootRun` or
- Run the `bootRun` Gradle task in your IDE.
- Use Postman to call http://localhost:8080/transactions/{page}

## Assumptions and stretch goals
- In the future the application should be more secure. Each API should check that an authorized user is accessing its data.
- In the future the running total API end point should allow the use to specify a range of dates.
- In the future a page size should be specified everytime the main API /{page} is called in case the total count of transactions for a page size is extremely large.
- In the future more tests could be added at the Controller level.