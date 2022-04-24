# 📭 Consumer

This service receives notifications from the system related to update operations its function is updated as information responsible for the requested book and sends the information of this operation to a KAFKA topic

## Requirements:
### Environment variable
`export QUEUE_URL=Your_queue_url`
### AWS Credentials
> In you directory root create (.aws) directory and put (credentials) file
```
[default]
aws_access_key_id = your aws_access_key_id
aws_secret_access_key = your aws_secret_access_key
```
## Run
> In you directory root for project with database up. run commands
1. `mvn clean package`
2. `java -jar -Dspring.profiles.active=env targe/*.jar`

## Env files
1. Local
2. AWS