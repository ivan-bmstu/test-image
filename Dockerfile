FROM eclipse-temurin:21

WORKDIR codebase
ADD . .
RUN apt-get update && apt-get install dos2unix && dos2unix ./mvnw

RUN ["./mvnw", "clean", "install", "-DskipTests"]
EXPOSE 9999

ENTRYPOINT ["java", "-jar", "./target/BackendApp.jar"]
