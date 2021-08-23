#FROM openjdk:11
#VOLUME /tmp
#ARG JAVA_OPTS
#ENV JAVA_OPTS=$JAVA_OPTS
#ENV PORT 8080
#COPY target/Practica-Quasar-1.0-SNAPSHOT.jar practicaquasar.jar 
#EXPOSE 8080
#ENTRYPOINT exec java $JAVA_OPTS -jar practicaquasar.jar
# For Spring-Boot project, use the entrypoint below to reduce Tomcat startup time.
#ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar practicaquasar.jar

# syntax=docker/dockerfile:1

#
#FROM openjdk:11
#WORKDIR /app
#COPY .mvn ./mvn
#COPY mvnw pom.xml ./
#COPY src ./src
##RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)
#CMD ["./mvnw", "spring-boot:run"]

#ENV PORT 8080
#EXPOSE 8080
#Maven build container 

#
# Build stage
#
FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

#
# Package stage
#
FROM openjdk:11-jre-slim
COPY --from=build /home/app/target/Practica-Quasar-1.0-SNAPSHOT.jar /usr/local/lib/Practica-Quasar.jar
EXPOSE 8080
ENV PORT 8080
ENTRYPOINT ["java","-jar","/usr/local/lib/Practica-Quasar.jar"]