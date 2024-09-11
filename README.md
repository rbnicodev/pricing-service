# Pricing Service: Spring Boot application services for pricing management

This microservice provides prices for products stored in a database.
This is a technical test for an interview.

## Prerequisites

- Docker: [Download and install Docker](https://docs.docker.com/get-docker/)
- Docker Compose (optional): [Download and install Docker Compose](https://docs.docker.com/compose/install/)

## Project Structure

- `Dockerfile`: Contains the instructions to build the Docker image for the application.
- `src/main/java`: Application source code.
- `src/main/resources`: Application resources (e.g., configuration files).

## Build the Docker Image

To build the Docker image for the application, run the following command in the root directory of the project (where the `Dockerfile` is located):

##RUN
```bash
docker-compose up app --build```

##DEV
```
docker-compose up app-dev --build
```