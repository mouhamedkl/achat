FROM openjdk:8
WORKDIR /app
RUN apt-get update && apt-get install -y curl \
    && curl -u admin:root -O http://172.27.122.88:8081/repository/maven-releases/tn/esprit/rh/achat/1.0/achat-1.0.jar
RUN apt-get remove -y curl && apt-get clean
EXPOSE 8089
CMD ["java", "-jar", "achat-1.0.jar"]
