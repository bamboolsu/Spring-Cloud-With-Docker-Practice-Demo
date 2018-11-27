FROM openjdk:8-jre
VOLUME /tmp
ARG JAR_FILE
ADD ${JAR_FILE} app.jar
RUN bash -c 'touch /app.jar'
EXPOSE 8010
ENTRYPOINT ["java","-Djava.security.egd=file:dev/./urandom","-jar","/app.jar"]