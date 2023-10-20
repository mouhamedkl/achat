FROM openjdk:11-jre-slim

ARG NEXUS_REPO_URL
ARG NEXUS_USERNAME
ARG NEXUS_PASSWORD
ARG APP_JAR
ENV NEXUS_REPO_URL=$NEXUS_REPO_URL
ENV NEXUS_USERNAME=$NEXUS_USERNAME
ENV NEXUS_PASSWORD=$NEXUS_PASSWORD
ENV APP_JAR=$APP_JAR

WORKDIR /app
COPY .env.dev .env
RUN apt-get update && apt-get install -y curl \
    && curl -u $NEXUS_USERNAME:$NEXUS_PASSWORD -O $NEXUS_REPO_URL/repository/achat-repo/tn/esprit/rh/achat/1.0/achat-1.0.jar
RUN apt-get remove -y curl && apt-get clean
EXPOSE 8089
CMD ["java", "-jar", "achat-1.0.jar"]