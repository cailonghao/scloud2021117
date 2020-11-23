FROM openjdk:8-jdk-alpine

WORKDIR /usr/local/src

COPY target/source-0.0.1-SNAPSHOT.jar /usr/local/src/app.jar

EXPOSE 20000

CMD java -jar app.jar