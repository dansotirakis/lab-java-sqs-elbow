#!/bin/bash
aws configure set aws_access_key_id "$AWS_SECRET_ACCESS_KEY"
aws configure set aws_secret_access_key "$AWS_SECRET_ACCESS_KEY"
aws configure set region "$AWS_REGION"
aws --endpoint-url="$AWS_URL" sqs list-queues