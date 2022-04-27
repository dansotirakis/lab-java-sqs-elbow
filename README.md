# ⚗️ lab-java-sqs-elbow
## 🦾 It is an elbow in crud application using sqs at AWS 🦾

The project consists of an applied study of the use of SQS to provide a message queue and the use of this technology to perform part of the operations of a system. 
The main features of the project is its ability to isolate part of the operations of one service from another, which allows for greater adherence to event-oriented architecture design practices and facilitates the execution of audit procedures without overloading the operations.

### Phase 1:
#### Apps
- Producer
- Consumer

### Build LocalStack using Docker and Mysql and create queue with cli
```shell
sudo docker-compose -f docker-compose-localstack.yml up -d
export AWS_SECRET_ACCESS_KEY="FAKE"
export AWS_ACCESS_KEY_ID="FAKE"
export AWS_DEFAULT_REGION=us-east-1 
export AWS_DEFAULT_OUTPUT=json
aws --endpoint-url=http://localhost:4566 sqs create-queue --queue-name elbow.fifo --attributes FifoQueue=true
```
