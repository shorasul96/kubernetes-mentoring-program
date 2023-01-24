FROM adoptopenjdk:11-jre-hotspot
EXPOSE 8091
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} post-service.jar
ENTRYPOINT ["java","-jar","/post-service.jar"]