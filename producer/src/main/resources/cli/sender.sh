aws sqs send-message --queue-url "$QUEUE_URL" \
  --message-body file://aws-sqs-body.json \
  --message-group-id "$RANDOM" \
  --message-deduplication-id "$RANDOM" \
  --message-attributes file://aws-sqs-attributes.json;