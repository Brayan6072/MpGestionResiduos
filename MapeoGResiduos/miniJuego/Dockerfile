FROM openjdk:22-jdk-slim
ARG JAR_FILE=target/Microsevicio_MiniJuego.jar
COPY ${JAR_FILE} mcsv-minijuego.jar
EXPOSE 9990
ENTRYPOINT ["java", "-jar", "mcsv-minijuego.jar"]

