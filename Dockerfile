# Étape 1 : build avec Java 21
FROM gradle:8.5-jdk21 AS build
WORKDIR /app
COPY . .
RUN gradle build --no-daemon

# Étape 2 : exécution avec Java 21
FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY --from=build /app/build/libs/*.jar app.jar
EXPOSE 4040
ENTRYPOINT ["java", "-jar", "app.jar"]
