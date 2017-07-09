FROM anapsix/alpine-java

COPY build/libs/hamburg-service-0.1.0.jar /opt/hamburg-service.jar

EXPOSE 8080
WORKDIR /opt
CMD java -jar /opt/hamburg-service.jar
