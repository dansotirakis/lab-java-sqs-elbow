# 📭 Consumer
> This service receives notifications from the system related to update operations its function is updated as information responsible for the requested book and sends the information of this operation to a KAFKA topic
## Run - aws
> Pre-configured credential AWS and configure your environment variables is required
```shell
export QUEUE_URL=""
export DS_URL=""
export DS_PASS=""
export DS_USR=""
mvn clean package 
java -jar -Dspring.profiles.active=aws target/*.jar
```
## Run - localstack
> Required database and localstack up
```shell
export AWS_SECRET_ACCESS_KEY="FAKE"
export AWS_ACCESS_KEY_ID="FAKE"
export AWS_DEFAULT_REGION=us-east-1
export QUEUE_URL="http://127.0.0.1:4566/000000000000/elbow.fifo"
export DS_URL="jdbc:mysql://127.0.0.1:3306/elbowdb"
export DS_PASS="mauFJcuf5dhRMQrjj"
export DS_USR="root"
mvn clean package
java -jar -Dspring.profiles.active=local target/*.jar
```
## CLI
### Read queue
```shell
export AWS_SECRET_ACCESS_KEY="FAKE"
export AWS_ACCESS_KEY_ID="FAKE"
export AWS_DEFAULT_REGION=us-east-1
aws --endpoint-url http://127.0.0.1:4566 sqs receive-message --queue-url http://127.0.0.1:4566/000000000000/elbow.fifo
```
### Purge queue
```shell
export AWS_SECRET_ACCESS_KEY="FAKE"
export AWS_ACCESS_KEY_ID="FAKE"
export AWS_DEFAULT_REGION=us-east-1
aws --endpoint-url http://127.0.0.1:4566 sqs purge-queue --queue-url http://127.0.0.1:4566/000000000000/elbow.fifo
```

## Run tests and view jacoco report at Browser (Google Chrome)
```shell
aws --endpoint-url=http://localhost:4566 sqs create-queue --queue-name elbow.fifo --attributes FifoQueue=true
mvn clean package
mvn jacoco:report
google-chrome ~/_code/lab-java-sqs-elbow/consumer/target/site/jacoco/index.html
```