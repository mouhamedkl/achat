# Use an official OpenJDK runtime as a parent image
FROM openjdk:11-jre-slim

# Set environment variables for Nexus and application
ENV NEXUS_REPO_URL="http://192.168.222.123:8081/repository/achat-repo/"
ENV NEXUS_USERNAME="admin"
ENV NEXUS_PASSWORD="root"
ENV APP_JAR="achat-1.0.jar"

# Create a directory for your application
WORKDIR /app

# Download the application JAR from Nexus using curl with authentication
RUN apt-get update && apt-get install -y curl \
    && curl -u $NEXUS_USERNAME:$NEXUS_PASSWORD -O $NEXUS_REPO_URL/repository/achat-repo/tn/esprit/rh/achat/1.0/achat-1.0.jar

# Remove curl after use
RUN apt-get remove -y curl && apt-get clean

# Expose the port on which your Spring Boot app runs (if necessary)
EXPOSE 8089

# Run the application
CMD ["java", "-jar", "achat-1.0.jar"]