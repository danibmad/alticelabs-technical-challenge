# alticelabs-technical-challenge

**Author: Daniel Madaíl**

# LabSeq Application

Full-stack implementation of the **LabSeq sequence calculator**.  
Includes:
- **Backend**: Quarkus (Java 21)
- **Frontend**: Angular
- **Containerization**: Docker & Docker Compose

---
##  Prerequisites

For **local setup** (without Docker):

| Tool | Version | Purpose |
|------|----------|----------|
| [Java](https://adoptium.net) | 21+ | Run Quarkus backend |
| [Maven](https://maven.apache.org/) | 3.9+ | Build backend |
| [Node.js](https://nodejs.org/en/) | 18+ | Run Angular frontend |
| [npm](https://www.npmjs.com/) | 9+ | Package manager |
| [Docker Desktop](https://www.docker.com/) | latest | Containerized setup |

---

## Running the Application (Requires Docker)

Run both backend and frontend with a single command.

```
docker compose up --build
```


Once built:

Frontend	- Angular UI

http://localhost:4200


Backend API	- REST endpoint

http://localhost:8080/labseq/{n}


Swagger UI	- API documentation

http://localhost:8080/q/swagger-ui


##  Running Backend Unit Tests

All backend tests are located under:

labseq-api-quarkus/src/test/java/com/labseq/


To run all tests:

```
cd labseq-api-quarkus
```


```
./mvnw test
```

Test reports are available in:

labseq-api-quarkus/target/surefire-reports/
