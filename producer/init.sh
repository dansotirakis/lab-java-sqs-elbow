#!/bin/bash
aws configure set aws_access_key_id "$AWS_SECRET_ACCESS_KEY"
aws configure set aws_secret_access_key "$AWS_SECRET_ACCESS_KEY"
aws configure set region "$AWS_REGION"
aws --endpoint-url="$AWS_URL" sqs create-queue --queue-name "$QUEUE_NAME" --attributes FifoQueue=true
java -jar -Dspring.profiles.active=local /java-application.jar