**TMB Assignment RestAssured Framework**
-----

**About the framework:**

**This is a Test Driven API Automation Framework built using:**
- Rest Assured library to automate REST APIs
- Java as programming language
- Maven to build the project and for dependencies
- TestNG framework for triggering the tests
- JSON file (as per the assignment) for test data
- Docker for dockerizing the tests through Dockerfile (built through GitHub Actions)
- Github Actions for CI/triggering the workflow on code commit (push or merge)

-----

**Have leveraged the below for writing readable code:**
- Test DataSupplier for fetching the data from JSON file and passing it to the test
- Custom assertions using AssertJ for fluent and readable tests
- POJOs for serialization and deserialization
- Lombok using builder pattern for reducing boilerplate code while creating POJO
- Owner library for reducing verbosity and boilerplate code for reading properties file

Code for integrating Extent reports or Allure reports could be written. The test results can be seen on the GitHub Actions runs for now.

---

**The framework has separation of concerns. It:**
- Follows the Arrange, Act and Assert pattern for the test (Currently, there is only one test as per the assignment).
- Has two assertions within the test
- Follows coding standards and naming conventions for classes, methods, variables, constants
- Makes use of Optional library for checking and returning request and response specification values
- Uses static method for constructor instantiation for building request and response specification under RequestResponseSpecCreatorUtils class
- Uses Generics as return type under RequestCreatorUtility and ResponseParserUtility classes
- Uses Builder design pattern
- Uses KISS, DRY, SRP principles

_________________________________

**How to use this framework?**

- Clone the repository to your workspace.
- Go to testng.xml file and run it.
- The testng.xml file can also be triggered through pom.xml file with the help of maven surefire plugin from command line using the below command:
mvn clean test.
After cloning the repository to your workspace, go to the project's path and execute the above command.
- The automated tests have also been dockerized, so its image can also be pulled and used from docker hub.

_________________________________

**How the framework works?**

- Once the code is triggered from testng.xml file, the tests in the class mentioned in testng.xml file get triggered.
- The test follows the Arrange, Act and Assert pattern: The request is hit, the response is parsed and the assertions are made
- All the background logic/implementation is abstracted out in other layers. Request creation logic is under RequestCreatorUtility and RequestResponseSpecCreatorUtils classes. Response extraction and parsing logic is under ResponseParserUtility and RequestResponseSpecCreatorUtils classes.
- Test Data is being passed from JSON file through Test DataSupplier and is being built in RequestTestDataBuilder class using POJOs and builder pattern
- The same User.java POJO is being used for serialization and deserialization since the two fields (name, job) required are common in request and response.
- Properties are being fetched from config.properties file using Owner library

If more tests are to be added in future, new test cases needs to be added using the same Arrange, Act and Assert pattern each having its own DataSupplier where relevant file will be passed for test data. But the background implementation remains the same - just need to leverage it as it is.
