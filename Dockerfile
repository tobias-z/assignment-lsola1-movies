FROM openjdk:8-alpine
WORKDIR /app
COPY target/assignment-lsola*.jar ./movies-api.jar
ENV MOVIES_SERVER_PORT 8080
ENV MOVIES_ELASTIC_SEARCH_HOST elasticsearch
ENV MOVIES_ELASTIC_SEARCH_PORT 9200
CMD [ "java", "-jar", "movies-api.jar"]
