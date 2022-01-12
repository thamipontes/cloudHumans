# cloudHumans
# Language
- Java 8 (for can use Heroku)
- You can install java with sdk manager

##Sdk Manager
```shell script
$ curl -s "https://get.sdkman.io" | bash
```
```shell script
$ source "$HOME/.sdkman/bin/sdkman-init.sh"
```
```shell script
$ sdk version
```
```shell script
$ sdk list java
```
- Choose one being version 8
```shell script
$ sdk install java [choose]
```
```shell script
$ sdk use java [choose]
```


#Build
```shell script
  ./gradlew build
```

#Run Spring Boot
```shell script
./gradlew bootRun
```

#Run Tests
```shell script
./gradlew test
```

#Run Spotless (Lint)
```shell script
./gradlew spotlessCheck
```

#Run Docker-compose for Sonarqube
```bash
docker-compose -f sonarqube.yml up
```

#Sonarqube
- In the browser, access the URL localhost:9000

- To login in SonarQube the default password and login are: admin(login), admin(password).

- Run project in SonarQube with:

```bash
./gradlew sonarqube
```

#Tools
- Spring Boot;
- Spotless;
- Git Actions for CI/CD;
- Sonarqube;
- Docker-compose;


