# syntax=docker/dockerfile:1.4

FROM maven:3.8.5-eclipse-temurin-17 AS builder
WORKDIR /app
COPY pom.xml /app/pom.xml
RUN mvn dependency:go-offline

COPY src /app/src
RUN mvn package -Dmaven.test.skip=true

FROM builder AS dev-envs
RUN apt-get update && apt-get install -y --no-install-recommends git

RUN useradd -s /bin/bash -m vscode && groupadd docker && usermod -aG docker vscode

# install Docker tools (cli, buildx, compose)
COPY --from=gloursdocker/docker / /
CMD ["mvn", "spring-boot:run"]

FROM builder as prepare-production
RUN mkdir -p target/dependency
WORKDIR /app/target/dependency
RUN jar -xf ../*.jar

FROM eclipse-temurin:17-jre-focal

EXPOSE 8080
VOLUME /tmp
WORKDIR /app

ARG JAR_FILE

COPY target/${JAR_FILE}  /app/api.jar
COPY wait-for-it.sh /wait-for-it.sh

RUN chmod +x /wait-for-it.sh

EXPOSE 8080

CMD ["java", "-jar", "api.jar"]