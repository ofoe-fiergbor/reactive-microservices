# Reactive Microservice with Spring boot and Spring Cloud

## ✅ Prerequisites

- Java 8 or higher
- Gradle
- Docker

## 🚀 Getting Started

1. Clone the repository: `git clone https://github.com/ofoe-fiergbor/reactive-microservices.git`
2. Navigate to the project directory: `cd reactive-microservices`
3. Build the project: `./gradlew build && docker-compose build`
4. Run the application: `docker-compose up -d`
5. Access the api docs in your browser at `http://localhost:8080/openapi/swagger-ui.html`

## 📂 Project Structure

```
- Api
- Microservices
    - Product Composite Service
    - Product Service
    - Recommendation Service
    - Review Service
- Spring Cloud
    - Eureka Server
    - Gateway
- Util
```