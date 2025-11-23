# Build stage
FROM maven:3.9-eclipse-temurin-17 as builder
WORKDIR /app
COPY pom.xml .
COPY src src
RUN mvn clean package -DskipTests

# Runtime stage
FROM eclipse-temurin:17-jdk-alpine
COPY --from=builder /app/target/*.jar app.jar
EXPOSE 8100
ENTRYPOINT [ "java", "-jar", "/app.jar" ]