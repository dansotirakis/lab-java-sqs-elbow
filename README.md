# sqs-elbow
Project consists of an applied study of the use of SQS to provide a message queue and the use of this technology to perform part of the operations of a system. 
The main features of the project is its ability to isolate part of the operations of one service from another, which allows for greater adherence to event-oriented architecture design practices and facilitates the execution of audit procedures without overloading the operations.
## Project structure
### Phase 1:
- Producer
- Consumer
### Phase 2:
- Camunda
- Dockerized
### Phase 3
- Worker
- Optimized 
## Docker-compose: Elbow Engine
```shell
 docker-compose --env-file env.elbow up -d --build
```
---
- [Camunda](http://localhost:8080/engine-rest/version)
- [Consumer](http://localhost:8081/actuator/health)
- [Producer](http://localhost:8082/actuator/health)
- [Worker](#)