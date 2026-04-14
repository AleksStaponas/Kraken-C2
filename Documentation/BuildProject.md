# How to build and run the project with Docker

## Requirements

Before you start, make sure you have the following installed:

- Java 17 or higher
- Maven 3.8+
- Docker
- Docker Compose (v2 recommended)

You can verify installations with:

```bash
java -version
mvn -version
docker -v
docker compose version
```

------------------------------------------------------------------------
## 1. Build the Project

Before running Docker, you need to compile the project and generate the
required JAR files.

Run:

```
mvn clean package -DskipTests
```

This will: - Compile the code
- Skip running tests
- Generate the following jar files api.jar and cli.jar

These files are required for the Docker images.

## 2. Start the Application with Docker

Once the build is complete, start all services using Docker Compose:

docker compose up --build

This command will: - Build Docker images for the API and CLI
- Start PostgreSQL and MongoDB containers
- Launch the backend API service
- Launch the CLI service
- Create a Docker network for internal communication

### Example Output

After running the command, you should see output similar to:

```
[+] Building 9.3s (16/16) FINISHED
[+] up 7/7
✔ Image kraken-backend-app            Built                                                
✔ Image kraken-backend-java-shell     Built                                                                                                                     
✔ Network kraken-backend_default      Created                                                                                                                     
✔ Container kraken-backend-postgres-1 Created                                                                                                                     
✔ Container kraken-backend-mongo-1    Created                                                                                                                     
✔ Container kraken-api                Created                                                                                                                     
✔ Container kraken-cli                Created                                                                                                                     
Attaching to kraken-api, mongo-1, postgres-1, kraken-cli
```

## 3. Stop the Application

To stop all running services:

```
docker compose down
```

This will: - Stop all containers
- Remove the Docker network
- Keep built images for faster restarts

## 4. Rebuild After Changes

If you make changes to the code, rebuild the project using:

```
mvn clean package -DskipTests
docker compose up --build
```