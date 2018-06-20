FROM openjdk:8-jdk-alpine
VOLUME /tmp

COPY target/localstack-showcase.jar app.jar

ENTRYPOINT ["java", "-Dshowcase.sqs.endpoint=http://localstack:4576", "-Djava.security.egd=file:/dev/./urandom","-jar", "/app.jar"]