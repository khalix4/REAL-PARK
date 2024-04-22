FROM openjdk

EXPOSE 8080

ADD target/spring-boot-park.jar spring-boot-park.jar 

ENTRYPOINT [ "java","-jar","/spring-boot-park.jar" ]
