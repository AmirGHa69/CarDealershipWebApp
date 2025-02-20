# Use Maven base image to build the application
FROM maven:3.8.7-eclipse-temurin-17 AS build
# Set the working directory inside the container
WORKDIR /app
# Copy the pom.xml and download dependencies (better caching)
COPY pom.xml ./
RUN mvn dependency:resolve
# Copy the rest of the project files and build the application
COPY . .
RUN mvn clean package -DskipTests
# Start a new stage for runtime to keep the image lightweight
FROM eclipse-temurin:17-jdk-jammy
# Set working directory for runtime container
WORKDIR /app
# Copy the jar file from the build stage
COPY --from=build /app/target/*.jar app.jar
# Expose the application port
EXPOSE 8080
# Set the entry point to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]