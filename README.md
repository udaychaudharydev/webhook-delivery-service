# Webhook Delivery Service

A reliable webhook delivery service built with Java and Micronaut.

## Requirements

- Java 25
- Docker

## Start PostgreSQL

Create and start the PostgreSQL container:

```bash
docker run --name webhook-postgres \
  -e POSTGRES_DB=webhook_delivery \
  -e POSTGRES_USER=webhook \
  -e POSTGRES_PASSWORD=webhook \
  -p 5434:5432 \
  -d postgres:18