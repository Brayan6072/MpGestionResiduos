FROM openjdk:22-jdk-slim
ARG JAR_FILE=target/login-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} microservice-login.jar
RUN apt-get update && apt-get install -y curl
EXPOSE 9090
ENTRYPOINT ["java", "-jar", "microservice-login.jar"]