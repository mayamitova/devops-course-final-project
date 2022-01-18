FROM openjdk:11
#VOLUME /devops-final-project
EXPOSE 10333
RUN mkdir -p /app/
RUN mkdir -p /app/logs/
ADD build/libs/devops-final-project-0.0.1.jar /app/app.jar
ENTRYPOINT ["java","-Dspring.profiles.active=container", "-jar", "/app/app.jar"]