FROM alpine
RUN apk add openjdk11
WORKDIR /app
COPY .env.dev .env
RUN apt-get update && apt-get install -y curl \
    && curl -u $NEXUS_USERNAME:$NEXUS_PASSWORD -O $NEXUS_REPO_URL/repository/achat-repo/tn/esprit/rh/achat/1.0/achat-1.0.jar
RUN apt-get remove -y curl && apt-get clean
EXPOSE 8089
CMD ["java", "-jar", "achat-1.0.jar"]
