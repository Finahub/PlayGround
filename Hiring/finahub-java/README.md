# AirTable - Server - Spring Boot

This project helps to fetch bank info from https://airtable.com/shrLW24i9g40XV9Ab

### Developed using :
  - Spring Boot 2 (Java ofcourse)
  - H2
  - Httpie


### Dependencies
 - JDK 1.8 or later
 - Gradle 4+
 - IntelliJ IDEA o

### Installation
```sh
$ cd finahub-java
$ ./gradlew bootRun
```
### End Points
- H2 Saved Banks 
```sh
$ http :8081/banks
```

- AirTable Banks
```sh
$ http :8081/banks/airtable
```

- AirTable Random Bank
```sh
$ http :8081/banks/airtable/random
```

- Post Bank data to H2
```sh
$ http :8081/banks
```


