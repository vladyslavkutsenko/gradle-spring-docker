FROM java:8

MAINTAINER Johannes Unterstein <junterstein@mesosphere.io>

ADD build/libs/chucknorris-service-0.0.1-SNAPSHOT.jar /app.jar
EXPOSE 8080

CMD ["java", "-jar", "/app.jar"]
