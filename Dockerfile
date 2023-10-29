FROM openjdk:11
WORKDIR /app
EXPOSE 8089
RUN curl -O http://192.168.1.120:8081/repository/maven-releases/tn.esprit.rh/achat/1.0/achat-1.0.jar
CMD ["java","-jar","achat-1.0.jar"]
