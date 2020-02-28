# Casino zitroGames

Casino ZitroGames: Springboot + MongoDb + JWT

First of all it is necessary to connect with the casino to get a token. This service will return a Json Web Token that is necessary for the each game. Each casino controller needs a JWT.

The player can play until the money runs out or the token expires.  

In MongoDb there are 2 collections, one (user) to check user money balance, and other to save all transactions (transaction).

Feel free to change any configuration of any game in application.yml.

## Getting Started


### Run with docker-compose

In the root of the project run:

```
 mvn -Dmaven.test.skip=true install
 
 docker-compose up 
```

This will build and start one container for the rest api casino and another container with a mongoDb image.

** Remember first to stop the mongoDb service in your computer


### Run with Docker

In the root of the project build and run image:  

```
 mvn -Dmaven.test.skip=true install

 docker build -t zitrogames .  
 
 docker run -p 8081:8081 -d --net="host" -it zitrogames
```

### Run tests

To test the boot jar you must have a mongodb installed on your computer.
In the root of the project run:

```
 mvn test
```


### Swagger

Once the application is started with docker-compose it can be tested with swagger:

[http://localhost:8081/swagger-ui.html](http://localhost:8081/swagger-ui.html)

### Improving

DTOs  to return transaction to the player.  

More Integration tests and DTOs test.

Handle custom exceptions.


### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.2.4.RELEASE/maven-plugin/)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.2.4.RELEASE/reference/htmlsingle/#boot-features-developing-web-applications)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.2.4.RELEASE/reference/htmlsingle/#boot-features-jpa-and-spring-data)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)

