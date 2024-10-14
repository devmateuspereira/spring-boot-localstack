@echo off

echo ### Criando Queue(Standard) no SQS do LocalStack...
aws --endpoint http://localhost:4566 --profile localstack sqs create-queue --queue-name sqsHelloWorld --region us-east-1
aws --endpoint http://localhost:4566 --profile localstack sqs send-message --queue-url https://localhost.localstack.cloud:4566/000000000000/sqsHelloWorld --message-body "Hello World SQS!!!" --delay-seconds 1
aws --endpoint http://localhost:4566 --profile localstack sqs receive-message --queue-url https://localhost.localstack.cloud:4566/000000000000/sqsHelloWorld
aws --endpoint http://localhost:4566 --profile localstack sqs list-queues --region us-east-1

echo ### Criando Queue(Standard) no SNS do LocalStack...
aws --endpoint http://localhost:4566 --profile localstack sns create-topic --name snsHelloWorld
aws --endpoint http://localhost:4566 --profile localstack sns subscribe --topic-arn arn:aws:sns:us-east-1:000000000000:snsHelloWorld --protocol sqs --notification-endpoint arn:aws:sqs:us-east-1:000000000000:sqsHelloWorld
aws --endpoint http://localhost:4566 --profile localstack sns list-topics --region us-east-1