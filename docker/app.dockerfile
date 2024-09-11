FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /api
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn package
FROM openjdk:17-jdk-slim
WORKDIR /api
COPY --from=build /api/target/pricing-service-0.0.1-SNAPSHOT.jar /api/pricing-service.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/api/pricing-service.jar"]
