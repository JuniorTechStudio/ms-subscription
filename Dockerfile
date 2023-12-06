FROM bellsoft/liberica-openjdk-alpine:21
ARG JAR_FILE=build/libs/ms-subscription-*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
