# Back-end Java Program
- The Dyson Student Education Management provides back-end Java code, utilizing the Spring Boot framework and Maven for project management.
- springboot version：3.2.5
- java version: 17
- JDK version: 17.0.8
- The program design adopts the MVC (Model-View-Controller) architectural pattern.


## I.架构详解
**controller**: This package contains the controller layer responsible for handling user requests. Controllers receive HTTP requests, make decisions about business logic, and return responses.

**ervice**: This package constitutes the service layer, which executes the business logic. The service layer is situated between the controller and the data access layer and typically involves transaction management and execution logic of the business model.

**dao(Repository)**: The Data Access Object (DAO) or mapper layer package, in charge of interaction with the database. This project uses MyBatis technology for database querying and data retrieval.

**entity**: This package includes entity classes that correspond to the tables in the database, with the entity attributes mapping to the table's field information.


## II.项目结构
- `src/main/java/com.example.StudentManagement` contains the primary code of the application
  - `Controller` class that handle HTTP requests
  - `Dao` data access object classes that interact with the database
  - `Entity` class that map to database tables
  - `Service` class that contain the business logic of the application
  - `StudentManagementApplication.java`: the main entry point of the Spring Boot application
- `src/main/resources`
  - `Mapper`: Data mapping files
  - `static`: Static resource files
  - `templates`: Template files
  - `application.yml`: The main configuration file for the Spring Boot application (includes port and MyBatis mappings)
- `pom.xml`is used for Maven build and execution, containing all project-related dependencies

## III.dependences
        //web development
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

        <dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>

        //springboot tools
		<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
			<optional>true</optional>
		</dependency>

        //mysql drive
		<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
			<version>8.0.13</version>
		</dependency>

        //jdbc
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-jdbc</artifactId>
		</dependency>

        //jpa
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
			<version>3.1.11</version>
		</dependency>

        //mybatis
		<dependency>
			<groupId>com.baomidou</groupId>
			<artifactId>mybatis-plus-boot-starter</artifactId>
			<version>3.5.1</version>
		</dependency>




