#Our layer
FROM maven:3-jdk-8 as builder
WORKDIR /project
COPY entities/ entities
WORKDIR /project/entities
RUN mvn install
WORKDIR /project
COPY blogpostmanager .
RUN mvn package

#New layer
FROM java:8-alpine
WORKDIR /app
COPY --from=builder /project/target/blogpostmanager-0.0.1-SNAPSHOT.jar ./blogpostmanager.jar
CMD java -jar usermanager.jar