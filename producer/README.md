# 📬 Producer

This service is responsible for carrying out all the operations of creating, removing and consulting books and must pass the update operations via SQS to the service that will perform this operation.

## Requirements:
### Environment variable
    export QUEUE_URL=Your_queue_url;
    export DS_URL=Your_db_url;
    export DS_PASS=Your_db_pass;
    export DS_USR=Your_db_user;
> Resource: set your environment variables set-env.sh file on root directory and Run:
`. set-env.sh`

### AWS Credentials
> In your root directory create the directory (.aws) and place the file (credentials) with the following content:
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

## Resource
> On `./cli` directory contains script `.sh` and `.json` files for using from sent messages for queue with AWS CLI