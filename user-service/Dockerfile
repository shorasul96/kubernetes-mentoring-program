FROM adoptopenjdk:11-jre-hotspot
EXPOSE 8091
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} user-service.jar
ENTRYPOINT ["java","-jar","/user-service.jar"]