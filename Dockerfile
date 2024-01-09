FROM maven:eclipse-temurin AS builder

WORKDIR /src

COPY mvnw .
COPY mvnw.cmd .
COPY .mvn .mvn
COPY src src
COPY pom.xml .

RUN mvn package -Dmaven.test.skip=true

FROM openjdk:21-jdk-slim

WORKDIR /app

COPY --from=builder /src/target/pafdemo21-0.0.1-SNAPSHOT.jar app.jar

ENV PORT=8080 SPRING_DATASOURCE_URL=url
ENV SPRING_DATASOURCE_USERNAME=username SPRING_DATASOURCE_PASSWORD=password

EXPOSE ${PORT}

ENTRYPOINT SERVER_PORT=${PORT} java -jar app.jar