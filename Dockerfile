FROM maven:3.8.5-openjdk-17 AS maven
WORKDIR /app
COPY . .
CMD ["mvn", "clean", "install"]

FROM openjdk:17 as runtime
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]