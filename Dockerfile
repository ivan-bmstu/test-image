FROM eclipse-temurin:21

EXPOSE 9999

RUN mkdir /opt/app
COPY ./target/BackendApp.jar /opt/app

CMD ["java", "-jar", "/opt/app/BackendApp.jar"]


