FROM maven:3.9.4-eclipse-temurin-17 AS build

COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-alpine

# Correcting the path, since your .jar file is under /target, not /app/target
COPY --from=build /target/tp-foyer-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "app.jar"]
