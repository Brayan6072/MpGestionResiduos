FROM openjdk:22-jdk-slim
ARG JAR_FILE=target/mcsv-reportes-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} mcsv-reportes.jar
EXPOSE 8099
ENTRYPOINT [ "java", "-jar", "mcsv-reportes.jar"]