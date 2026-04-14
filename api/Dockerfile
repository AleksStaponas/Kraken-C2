FROM eclipse-temurin:17-jdk

LABEL author="Aleks Staponas"

WORKDIR /app

COPY target/api.jar app.jar

EXPOSE 9090

ENTRYPOINT ["java", "-jar", "app.jar"]