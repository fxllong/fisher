FROM anapsix/alpine-java:8_server-jre_unlimited

COPY target/fisher-gateway-1.0-SNAPSHOT.jar /fisher-gateway-service.jar

ENTRYPOINT ["java", "-jar", "/fisher-gateway-service.jar"]

