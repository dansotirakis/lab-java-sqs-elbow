# Camunda engine JAVA
## Run
> Pre-configured credential AWS and configure your environment variables is required
```shell
export BOOK_API_URL="http://localhost:8082"
export DS_URL_CE="jdbc:postgresql://localhost:5432/camunda-engine-db"
export DS_PASS_CE="root"
export DS_USR_CE="camunda"
export URS_CE="sa"
export PASS_CE="root"
mvn clean package 
java -jar -Dspring.profiles.active=aws target/*.jar
```
## Build project using docker engine
```shell
docker-compose --env-file env.local up -d --build
```