FROM anapsix/alpine-java

COPY build/libs/info-app-0.1.0.jar /opt/info-app.jar

EXPOSE 8080
WORKDIR /opt
CMD java -jar /opt/info-app.jar
