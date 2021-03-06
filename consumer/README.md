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
```shell
export AWS_SECRET_ACCESS_KEY="FAKE"
export AWS_ACCESS_KEY_ID="FAKE"
export AWS_DEFAULT_REGION=us-east-1
export QUEUE_URL="http://localhost:4566/000000000000/elbow.fifo"
export DS_URL="jdbc:mysql://127.0.0.1:3306/elbowdb"
export DS_PASS="mauFJcuf5dhRMQrjj"
export DS_USR="root"
mvn clean package
# java -jar -Dspring.profiles.active=local target/*.jar
```
## Dockerfile
```shell
export AWS_SECRET_ACCESS_KEY="FAKE"
export AWS_ACCESS_KEY_ID="FAKE"
export AWS_DEFAULT_REGION=us-east-1
export QUEUE_URL="http://127.0.0.1:4566/000000000000/elbow.fifo"
export DS_URL="jdbc:mysql://localhost:3306/elbowdb"
export DS_PASS="mauFJcuf5dhRMQrjj"
export DS_USR="root"
docker build . \
--build-arg QUEUE_URL=$QUEUE_URL \
--build-arg DS_URL=$DS_URL \
--build-arg DS_PASS=$DS_PASS \
--build-arg DS_USR=$DS_USR \
--no-cache
```
## Junit report - Google Chrome
```shell
mvn clean package
mvn jacoco:report
google-chrome ~/_code/lab-java-sqs-elbow/consumer/target/site/jacoco/index.html
```
## CLI
### Read queue
```shell
export AWS_SECRET_ACCESS_KEY="FAKE"
export AWS_ACCESS_KEY_ID="FAKE"
export AWS_DEFAULT_REGION=us-east-1
aws --endpoint-url http://localhost:4566 sqs receive-message --queue-url http://localhost:4566/000000000000/elbow.fifo
```
### Purge queue
```shell
export AWS_SECRET_ACCESS_KEY="FAKE"
export AWS_ACCESS_KEY_ID="FAKE"
export AWS_DEFAULT_REGION=us-east-1
aws --endpoint-url http://localhost:4566 sqs purge-queue --queue-url http://localhost:4566/000000000000/elbow.fifo
```
### Creating queue
```shell
aws --endpoint-url=http://localhost:4566 sqs create-queue --queue-name elbow.fifo --attributes FifoQueue=true
```