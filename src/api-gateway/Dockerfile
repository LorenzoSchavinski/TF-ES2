# Build stage
FROM eclipse-temurin:17-jdk-alpine AS build
RUN apk add --no-cache maven bash
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests
RUN ls -la /app/target/ && \
    cd /app/target && \
    for jar in *.jar; do \
      if [[ "$jar" != *"original"* ]]; then \
        echo "Copying $jar to app.jar"; \
        cp "$jar" app.jar; \
        break; \
      fi; \
    done && \
    ls -la /app/target/app.jar || (echo "ERROR: app.jar not created!" && exit 1)

# Runtime stage
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=build /app/target/app.jar app.jar
RUN ls -la /app/ && test -f /app/app.jar || (echo "ERROR: app.jar not found in runtime stage!" && exit 1)
EXPOSE 8765
ENTRYPOINT [ "java", "-jar", "/app/app.jar" ]