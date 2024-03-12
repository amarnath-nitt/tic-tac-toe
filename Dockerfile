FROM maven:3-openjdk-17 As build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/tic_tac_toe-0.0.1-SNAPSHOT.jar tic_tac_toe.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "tic_tac_toe.jar"]
