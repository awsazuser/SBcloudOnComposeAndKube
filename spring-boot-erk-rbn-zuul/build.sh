
cd /root/spring-boot-netflix-oss-yml/demo-ribbon-client/
docker run -it --rm        -v "$(pwd)":/opt/maven        -w /opt/maven        maven:latest        mvn package
docker build -t ribbonclient .

cd /root/spring-boot-netflix-oss-yml/demo-eureka-service
docker run -it --rm        -v "$(pwd)":/opt/maven        -w /opt/maven        maven:latest        mvn package
docker build -t eurekaservice .

cd /root/spring-boot-netflix-oss-yml/demo-zuul-gateway/
docker run -it --rm        -v "$(pwd)":/opt/maven        -w /opt/maven        maven:latest        mvn package
docker build -t zuul .

cd /root/spring-boot-netflix-oss-yml/demo-eureka-client1/
docker run -it --rm        -v "$(pwd)":/opt/maven        -w /opt/maven        maven:latest        mvn package
docker build -t eurekaclient1 .

cd /root/spring-boot-netflix-oss-yml/demo-eureka-client2/
docker run -it --rm        -v "$(pwd)":/opt/maven        -w /opt/maven        maven:latest        mvn package
docker build -t eurekaclient2 .

