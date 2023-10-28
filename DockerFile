FROM openjdk:11
WORKDIR /app
EXPOSE 8089
# Download and copy the JAR artifact from Nexus repository into the image
ADD http://192.168.1.120:8081/repository/maven-releases/tn.esprit.rh/achat/1.0/achat-1.0.jar /achat-1.0.jar
CMD ["java","-jar","/achat-1.0.jar"]
