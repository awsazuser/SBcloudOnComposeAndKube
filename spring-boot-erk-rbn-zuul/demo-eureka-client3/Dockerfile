FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/demo-eureka-client3-0.0.1-SNAPSHOT.jar app.jar
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Dspring.data.mongodb.uri=mongodb://mongo-0/mongo -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]
