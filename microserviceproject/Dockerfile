# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
FROM java:7
VOLUME /tmp
ARG JAR_FILE
ADD ${JAR_FILE} mspOnDocker.jar
EXPOSE 8081
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/mspOnDocker.jar"]
