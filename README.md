![alt text](Netflix_Final_Project.png)
# Netflix Pathways BootCamp - Advanced Java


>This is the final project for the Spring 2023 Netflix Pathways Bootcamp.
 
>Contributors: Marco Martinez, Tremayne Duffus, Jonathan Sanchez, Bridget Torres

---

## Technologies Used: 

### Development
- Spring Boot
- Spring MVC
- JPA
- JSR303 Validation
- GraphQL
- Exception Handling

### Testing
- JUnit Testing / Integration Testing
- MockMVC
- Mockito

### Deployment
- AWS RDS
- CircleCI/CD

---

## Project Structure and Development

### Java Project:
- The Java code was developed in IntelliJ using the Spring Boot framework. 
- Spring MVC was used to create the REST API, and JPA was used to handle the database transactions.
- SR303 validation was used to validate incoming requests.
- Exception Handling was implemented to handle any errors that occurred during the execution of the API.

### Database
- MySQL was used for the database, and the schema was created using DBeaver.
- GraphQL was used to write GET requests from the database.
- Integration Testing was done to test the database schema and ensure that it was functioning correctly.

### Deployment
- The project was deployed through AWS RDS, which allowed for easy scaling and management of the database.
- CircleCI was used for Continuous Integration and Continuous Deployment, which ensured that any changes made to the code were automatically deployed to the production environment.

---

## Running the Project

To run the project, follow these steps:

1. Clone the repository
2. Set up a MySQL database with the correct schema
3. Update the application.properties file with the correct database connection details
4. Run the project using mvn spring-boot:run or run in IntelliJ and go to available port.


