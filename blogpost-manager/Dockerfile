#Our layer
FROM maven:3-openjdk-15 as builder
WORKDIR /project
COPY entities/ entities
WORKDIR /project/entities
RUN mvn install
WORKDIR /project
COPY blogpost-manager .
RUN mvn package

#New layer
FROM java:15-alpine
WORKDIR /app
COPY --from=builder /project/target/blogpost-manager-0.0.1-SNAPSHOT.jar ./blogpost-manager.jar
CMD java -jar blogpost-manager.jar