FROM openjdk:22-jdk-slim
ARG JAR_FILE=target/mcsv-config-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} mcsv-config.jar
COPY src/main/resources/configurations /configurations
EXPOSE 8888
ENTRYPOINT [ "java", "-jar", "mcsv-config.jar"]
