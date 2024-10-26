# RestAssured API Automation with Allure Reports

## Project Overview

This project is an automation framework for testing APIs using RestAssured, with Allure for reporting. It includes tests
for user-related endpoints from the [Reqres API](https://reqres.in/).

## Prerequisites

- **Java** (version 1.8 or higher)
- **Maven** (version 3.6.0 or higher)
- **IDE** (e.g., IntelliJ IDEA, Eclipse)
- **Allure Commandline** (optional for local report serving)

## Project Setup

1. **Clone the repository:**
   ```bash
   git clone https://github.com/EsRaaAZZam/ecommerce-task.git
   cd API-Framework/

## Running Tests

To run the API tests and generate Allure results:

mvn clean test

## Generating Allure Reports

1. After running the tests, generate the Allure report:

mvn allure:report

2. To view the report, serve it with:

mvn allure:serve