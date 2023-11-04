# Use the official OpenJDK 8 image as the base image
FROM openjdk:8

# Expose the port your application will run on
EXPOSE 8089

# Set environment variables
ENV NEXUS_USERNAME=admin
ENV NEXUS_PASSWORD=midou
ENV NEXUS_REPO_URL=http://192.168.57.131:8081/repository/maven-releases/tn/esprit/rh/achat/1.1/achat-1.1.jar

# Download the JAR file from Nexus and copy it to the container
RUN curl -L -o achat.jar -u $NEXUS_USERNAME:$NEXUS_PASSWORD $NEXUS_REPO_URL

# Define the entry point for your application
ENTRYPOINT ["java", "-jar", "achat.jar"]
