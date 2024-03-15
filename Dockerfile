FROM eclipse-temurin:21

RUN apt-get update && apt-get install dos2unix

WORKDIR codebase
ADD . .

RUN ["./mvnw", "clean", "install", "-DskipTests"]
EXPOSE 9999

ENTRYPOINT ["java", "-jar", "./target/BackendApp.jar"]
