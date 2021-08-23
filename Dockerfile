FROM adoptopenjdk/openjdk11:ubi
VOLUME /tmp
ARG JAVA_OPTS
ENV JAVA_OPTS=$JAVA_OPTS
ENV PORT 8080
COPY target/Practica-Quasar-1.0-SNAPSHOT.jar practicaquasar.jar 
EXPOSE 8080
ENTRYPOINT exec java $JAVA_OPTS -jar practicaquasar.jar
# For Spring-Boot project, use the entrypoint below to reduce Tomcat startup time.
#ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar practicaquasar.jar
