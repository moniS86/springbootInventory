FROM openjdk:8-jdk-alpine
VOLUME /TMP
EXPOSE 8080
ADD target/*jar app.jar
ENTRYPOINT ["sh", "-c", "java","-jar", "/app.jar"]
