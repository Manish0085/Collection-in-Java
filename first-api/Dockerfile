# Use lightweight OpenJDK 17 base image
FROM openjdk:17-jdk-alpine

# Metadata
LABEL maintainer="manishk57107@gmail.com"
LABEL version="1.0"
LABEL description="A Java Quotes Application"

# Working directory inside container
WORKDIR /app

# Copy the Spring Boot jar file into the container
COPY target/first-api-0.0.1-SNAPSHOT.jar /app/first-api-0.0.1-SNAPSHOT.jar

# Expose application port
EXPOSE 8081

# Command to run the application
ENTRYPOINT ["java", "-jar", "/app/first-api-0.0.1-SNAPSHOT.jar"]
