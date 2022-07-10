# sqs-elbow

Project consists of an applied study of the use of SQS to provide a message queue and the use of this technology to perform part of the operations of a system. 
The main features of the project is its ability to isolate part of the operations of one service from another, which allows for greater adherence to event-oriented architecture design practices and facilitates the execution of audit procedures without overloading the operations.

### Phase 1:
#### Apps
- Producer
- Consumer

### Phase 2:
#### Engine
- Camunda
- Dockerized

### Build project using docker-compose
```shell
sudo docker-compose --env-file env.local up -d --build
```