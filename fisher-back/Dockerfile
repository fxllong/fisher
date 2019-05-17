FROM anapsix/alpine-java:8_server-jre_unlimited

COPY target/fisher-back-1.0-SNAPSHOT.jar /fisher-back-service.jar

ENTRYPOINT ["java", "-jar", "/fisher-back-service.jar"]

