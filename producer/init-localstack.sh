xport AWS_SECRET_ACCESS_KEY="FAKE"
export AWS_ACCESS_KEY_ID="FAKE"
export AWS_DEFAULT_REGION=us-east-1
export QUEUE_URL="http://127.0.0.1:4566/000000000000/elbow.fifo"
export DS_URL="jdbc:mysql://localhost:3306/elbowdb"
export DS_PASS="mauFJcuf5dhRMQrjj"
export DS_USR="root"
mvn clean package
java -jar -Dspring.profiles.active=local target/*.jar