# Use an official OpenJDK runtime as a base image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Define a build argument for the JAR name
ARG JAR_NAME

# Copy the provided JAR file from the target directory to the container
COPY target/${JAR_NAME} app.jar

# Expose the application port
EXPOSE 8080

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]
