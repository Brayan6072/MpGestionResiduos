FROM openjdk:22-jdk-slim
ARG JAR_FILE=target/mcsv-eureka-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} mcsv-eureka.jar
EXPOSE 8761
ENTRYPOINT ["java", "-jar", "mcsv-eureka.jar"]

