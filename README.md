# ⚗️ lab-java-sqs-elbow
## 🦾 It is an elbow in crud application using sqs at AWS 🦾

The project consists of an applied study of the use of SQS to provide a message queue and the use of this technology to perform part of the operations of a system. 
The main features of the project is its ability to isolate part of the operations of one service from another, which allows for greater adherence to event-oriented architecture design practices and facilitates the execution of audit procedures without overloading the operations.

### Phase 1:
#### Two java applications - spring boot
- Producer
- Consumer
#### A relational database - mysql
- ElbowDB
`sudo docker-compose -f docker-compose-mysql.yml up`
#### Queue SQS - FIFO
- elbow.fifo

## Resource
> Set environment variables for this project using `set-env.sh` file on root directory and Run: `. set-env.sh`