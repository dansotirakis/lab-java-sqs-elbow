# 📬 Producer
> This service is responsible for carrying out all the operations of creating, removing and consulting books and must pass the update operations via SQS to the service that will perform this operation.
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
export DS_URL="jdbc:mysql://localhost:3306/elbowdb"
export DS_PASS="mauFJcuf5dhRMQrjj"
export DS_USR="root"
mvn clean package 
java -jar -Dspring.profiles.active=local target/*.jar
```
## CLI
### Sent message
```shell
export AWS_DEFAULT_REGION=us-east-1
export AWS_SECRET_ACCESS_KEY="FAKE"
export AWS_ACCESS_KEY_ID="FAKE"

aws sqs send-message \
--endpoint-url http://127.0.0.1:4566 \
--region us-east-1 \
--queue-url http://127.0.0.1:4566/000000000000/elbow.fifo \
--message-body file://src/main/resources/cli/aws-sqs-body.json \
--message-group-id "$RANDOM" \
--message-deduplication-id "$RANDOM" \
--message-attributes file://src/main/resources/cli/aws-sqs-attributes.json
```
## Run tests and view jacoco report at Browser (Google Chrome)
```shell
mvn clean package
mvn jacoco:report
google-chrome ~/_code/lab-java-sqs-elbow/producer/target/site/jacoco/index.html
```