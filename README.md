# Movies Microservice

## Group Members

- Frederik Johnsen, cph-fj111@cphbusiness.dk
- Jean-Poul Leth-Møller, cph-jl360@cphbusiness.dk
- Mathias Parking, cph-mp525@cphbusiness.dk
- Magdalena Wawrzak cph-mw216@cphbusiness.dk
- Tobias Zimmermann cph-tz11@cphbusiness.dk

## Introduction

This microservice provides the ability to search for movies and tv shows (although currently mocked).

It supports fuzzy finding as well as sorting based on best matches.

## Local Usage

To simply use the microservice, run the command:

```bash
docker compose -f app.docker-compose.yaml up -d --build
```

This will start both the Elasticsearch server and the movies' microservice.

By default, the microservice will be running on port 8080

### Configuration

The docker image `tobiaszimmer/assignment-lsola1-movies` allows for a few environment variables to change the default
behavior:

- MOVIES_SERVER_PORT - The movie microservice port
- MOVIES_ELASTIC_SEARCH_HOST - The elastic search host
- MOVIES_ELASTIC_SEARCH_PORT - The elastic search port

If you only want the Elasticsearch server running you can the command:

```bash
docker compose -f local.docker-compose.yaml -d --build
```

### Endpoints

The service only exposes a single endpoints in:

```http request
GET /search?q=searchquery
```

## Project Structure

- Config: Configuration such as spring beans and Elasticsearch setup
- Controller: The single search endpoint exposed by the microservice
- Dto: Objects used to transfer data from different layers in the system
- Model: The Product used to define the search items
- Repository: The ElasticsearchRepository used to connect to the Elasticsearch server
- Service: The search implementation


