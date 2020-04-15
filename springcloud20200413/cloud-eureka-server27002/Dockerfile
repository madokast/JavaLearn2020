FROM openjdk:8
MAINTAINER Madoka <578562554@qq.com>

# ADD target/lib           /root/dockerMicroServer/eurekaServer27002/lib

ADD target/cloud-eureka-server27002-1.0-SNAPSHOT.jar app.jar

EXPOSE 27002

ENTRYPOINT ["java", "-jar", "app.jar"]