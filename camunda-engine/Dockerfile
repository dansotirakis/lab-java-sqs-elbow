FROM adoptopenjdk/openjdk11:jre-11.0.9.1_1-alpine@sha256:b6ab039066382d39cfc843914ef1fc624aa60e2a16ede433509ccadd6d995b1f
RUN mkdir /app

ENV DS_URL_CE=$DS_URL_CE
ENV DS_PASS_CE=$DS_PASS_CE
ENV DS_USR_CE=$DS_USR_CE
ENV URS_CE=$USR_CE
ENV PASS_CE=$PASS_CE
ENV BOOK_API_URL=$BOOK_API_URL

COPY ./target/camunda-engine-1.0.0-SNAPSHOT.jar /java-application.jar
WORKDIR /usr/src/project
EXPOSE 8080
CMD "java" "-jar" "-Dspring.profiles.active=local" "/java-application.jar"