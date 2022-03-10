# syntax=docker/dockerfile:1

#FROM openjdk:16-alpine3.13

#WORKDIR /app

#COPY .mvn/ .mvn
#COPY mvnw pom.xml ./
#RUN ./mvnw dependency:go-offline

COPY src ./src

CMD ["./mvnw", "spring-boot:run"]


ARG JAR_FILE=target/RentComparator-0.0.1-SNAPSHOT.jar

# cd /opt/app
WORKDIR /opt/app

# cp target/spring-boot-web.jar /opt/app/app.jar
COPY ${JAR_FILE} RentComparator-0.0.1-SNAPSHOT.jar

# java -jar /opt/app/app.jar
ENTRYPOINT ["java","-jar","RentComparator-0.0.1-SNAPSHOT.jar"]