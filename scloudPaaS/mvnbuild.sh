docker run -it --rm        -v "$(pwd)":/opt/maven        -w /opt/maven        maven:latest        mvn package -Dmaven.test.skip=true
