### How to use this spring-boot project

- Install packages with `mvn package`
- Run `mvn spring-boot:run` for starting the application (or use your IDE)

Application (with the embedded H2 database) is ready to be used ! You can access the url below for testing it :

- Swagger UI : http://localhost:8080/swagger-ui.html
- H2 UI : http://localhost:8080/h2-console

> Don't forget to set the `JDBC URL` value as `jdbc:h2:mem:testdb` for H2 UI.

#### Restrictions
- use java 8

#### Step for execution in local
- Clone the repository to your workspace.
- Execute 'mvn spring-boot:run'
- Go to the Swagger UI : http://localhost:8080/swagger-ui.html
- Click on /authenticate api to generate the JWT token.
- Use the username : "admin" and password : "admin" in /authenticate post request and hit "Try it out!".
- Copy the JWT token in the response and click on "Authorize" button on the right top of the page to add the JWT token.
- Add the JWT token in the format "Bearer <JWT Token>"
- Rest of the api can be tested by clicking on "Try it out!" with the same JWT key.

#### Execute test case
- The test cases can be executed either individually or by executing `mvn package` .

#### My experience in Java

- I have 9 years experience in Java and I started to use Spring Boot from last 2 years
- I have experience working with Spring Core and Spring MVC as well.
- I am a quick learner and always ready to take new challenges.