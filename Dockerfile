FROM eclipse-temurin:21

RUN apt-get update && apt-get install dos2unix
WORKDIR codebase
COPY . .
CMD mvnw clean install
#EXPOSE 9999
#CMD ["java", "-jar", "./codebase/target/BackendApp.jar"]
ENTRYPOINT mvnw spring-boot:run


