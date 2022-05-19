FROM maven:3.6.3-jdk-8
WORKDIR /home/tmbapiassignment
COPY src /home/tmbapiassignment/src
COPY test-output /home/tmbapiassignment/test-output
COPY pom.xml /home/tmbapiassignment/pom.xml
COPY testng.xml /home/tmbapiassignment/testng.xml
ENTRYPOINT mvn test