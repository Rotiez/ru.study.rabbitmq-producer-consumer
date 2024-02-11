FROM openjdk:17.0.2-jdk-slim-buster

ARG JAR_FILE=build/libs/*.jar

COPY ${JAR_FILE} rabbitmq-producer.jar

EXPOSE 8080:8080

ENTRYPOINT ["java","-jar","/rabbitmq-producer.jar"]

ENV RABBITMQ_HOST=host.docker.internal