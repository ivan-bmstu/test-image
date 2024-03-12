FROM ubuntu:latest
EXPOSE 9999
RUN apt-get update && apt apt install -y git openjdk-21-jre maven

WORKDIR test-image
ADD ./target/try-make-image-0.0.1.jar .

ENTRYPOINT mvn spring-boot:run
