FROM openjdk:23-jdk-oracle AS builder

ARG COMPILED_DIR=/myapp

WORKDIR ${COMPILED_DIR}

COPY mvnw .
COPY pom.xml .
COPY src src
COPY .mvn .mvn

RUN chmod a+x ./mvnw && ./mvnw package -Dmaven.test.skip=true


# Do not need ENTRYPOINT for first stage as app will run in second stage
# ENTRYPOINT java -jar target/day18-0.0.1-SNAPSHOT.jar


# Second stage
FROM openjdk:23-jdk-oracle

ARG WORK_DIR=/app

WORKDIR ${WORK_DIR}

COPY --from=builder /myapp/target/day18-0.0.1-SNAPSHOT.jar day18app.jar

ENV SERVER_PORT=4000

# Expose is more for documenting --> show which Port the app is listening to
EXPOSE ${SERVER_PORT}

ENTRYPOINT java -jar day18app.jar

