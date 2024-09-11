FROM maven:3.8.5-openjdk-17
WORKDIR /api
COPY pom.xml .
RUN mvn dependency:go-offline
COPY . .
EXPOSE 8080
CMD ["mvn", "spring-boot:run"]
