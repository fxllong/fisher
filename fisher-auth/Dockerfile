FROM anapsix/alpine-java:8_server-jre_unlimited

COPY target/fisher-auth-1.0-SNAPSHOT.jar /fisher-auth-service.jar

ENTRYPOINT ["java", "-jar", "/fisher-auth-service.jar"]

