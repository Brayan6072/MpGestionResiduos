FROM openjdk:22-jdk-slim
ARG JAR_FILE=target/login-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} microservice-login.jar
EXPOSE 9090
ENTRYPOINT ["java", "-jar", "microservice-login.jar"]