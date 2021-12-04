FROM gradle:jdk17 as build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
COPY . .
RUN gradle build --no-daemon


FROM openjdk:17-alpine
WORKDIR /app
COPY --from=build /home/gradle/src/build/libs/nlg-server-0.3.jar .
COPY responses responses
ENV responses=responses

EXPOSE 8080
CMD ["java", "-jar", "-Dspring.profiles.active=default", "nlg-server-0.3.jar"]