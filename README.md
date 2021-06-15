# flightManager

### Technologies
* Spring
* PostgreSQL
* Maven
* React.js

### How to get it?
Just copy and run commands from below

```
git clone https://github.com/Cytaa/flightManager.git
```
Create new postgreSQL database (recommended name: "flightManager"). 

```
psql -U postgres
CREATE DATABASE flightManager
```

You have to change ```application.properties```
to match your postgreSQL. Here's how to do it.
```
server.port = [portToSetUpFrontEndOn]
spring.datasource.url = [yourDataBaseURL] 
spring.datasource.username = [yourPostgresUsername]
spring.datasource.password = [yourPostgresPassword]
```
### How to run it?

To run use following commands in ```backend``` folder

```
mvn package
mvn spring-boot:run
```

To run use following commands in ```frontend``` folder

```
npm install
npm start
```
