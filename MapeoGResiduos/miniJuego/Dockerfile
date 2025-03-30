FROM openjdk:22-jdk-slim
ARG JAR_FILE=target/Microsevicio_MiniJuego.jar
COPY ${JAR_FILE} mcsv-minijuego.jar
RUN apt-get update && apt-get install -y curl
EXPOSE 9990
ENTRYPOINT ["java", "-jar", "mcsv-minijuego.jar"]

