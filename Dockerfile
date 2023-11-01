# Use the official Alpine Linux image as the base image
FROM alpine:latest

# Install OpenJDK 11 using apk
RUN apk add openjdk11

# Create a working directory
WORKDIR /app

# Download the JAR file from your Nexus repository
RUN wget --http-user=admin --http-password=nexus -O achat-1.0.jar http://172.27.112.88:8081/repository/maven-releases/tn/esprit/rh/achat/1.0/achat-1.0.jar

# Expose the port if needed
EXPOSE 8089

# Set the entry point
ENTRYPOINT ["java", "-jar", "achat-1.0.jar"]

