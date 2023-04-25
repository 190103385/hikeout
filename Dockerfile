FROM openjdk:18
VOLUME /tmp
ARG JAR_FILE=build/libs/hikeout-0.0.1.jar
COPY ./build/libs/hikeout-0.0.1.jar hikeout.jar
ENTRYPOINT ["java","-jar","/hikeout.jar"]