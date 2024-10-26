## Registration Test Suite

# E-commerce Checkout Automation

A comprehensive framework for automated testing of the checkout process in e-commerce applications. This project utilizes Selenium WebDriver and TestNG to perform user registration, login, product selection, and order completion, ensuring a smooth and reliable shopping experience.


## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Getting Started](#getting-started)
- [Usage](#usage)
- [Test Configuration](#test-configuration)
- [run Test ](#running-tests)

## Introduction

This project aims to streamline the testing process for e-commerce applications by automating common user interactions such as registration, login, product selection, and checkout. By leveraging the Selenium WebDriver and TestNG frameworks, developers can quickly identify issues and ensure a high-quality user experience.

## Features

- User registration and login automation
- Product selection and cart management
- Automated checkout process
- Extent Reports integration for detailed reporting
- Cross-browser testing support (Chrome, Firefox || and browser can be configured)


## Technologies Used

- **Java** - The programming language used.
- **Selenium WebDriver** - For browser automation.
- **TestNG** - Testing framework for running tests.
- **Extent Reports** - For generating test reports.
- **Maven** - Project management and build automation tool.


## Getting Started

### Prerequisites

Before you begin, ensure you have the following software installed:

- Java 11 or higher
- Maven


### Installation

# Clone the repository
git clone https://github.com/yourusername/yourproject.git

# Navigate to the project directory
cd yourproject

# Install dependencies
mvn installs


## Test Configuration

### You can configure test parameters such as the browser type by modifying the configBrowser.properties file:

# Example configuration
driverType=chrome

### TestNG Suite Configuration

The TestNG XML configuration file, testng.xml, defines the suite for parallel execution across multiple browsers. It
contains two test cases:

Chrome Test
Firefox Test


## Running Tests

To run the tests, execute the TestNG suite defined in testng.xml. You can do this from the command line using Maven:
mvn test -DsuiteXmlFile=websiteTestNG.xml

### important note 
the registered user loses his access after while so make sure to update config file with valid user to test login

