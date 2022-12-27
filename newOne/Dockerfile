FROM maven:3.8.4-openjdk-17-slim AS MAVEN_BUILD

COPY ./ ./

RUN mvn clean package

FROM openjdk:17

COPY --from=MAVEN_BUILD /target/newOne-0.0.1-SNAPSHOT.jar /labtwo.jar

CMD ["java","-jar","/labtwo.jar"]