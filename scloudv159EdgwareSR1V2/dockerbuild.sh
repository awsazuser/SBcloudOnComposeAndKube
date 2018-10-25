cd /root/scloudv159EdgwareSR1V2/demo-ribbon-client/
docker build -t scrbcli .
docker tag scrbcli awsazuser/scrbcli:latest
docker push awsazuser/scrbcli:latest

cd /root/scloudv159EdgwareSR1V2/demo-eureka-service
docker build -t scesrv .
docker tag  scesrv awsazuser/scesrv:latest
docker push awsazuser/scesrv:latest

cd /root/scloudv159EdgwareSR1V2/demo-zuul-gateway/
docker build -t sczuul .
docker tag sczuul awsazuser/sczuul:latest
docker push awsazuser/sczuul:latest

cd /root/scloudv159EdgwareSR1V2/demo-eureka-client2/
docker build -t scecli2 .
docker tag scecli2 awsazuser/scecli2:latest
docker push awsazuser/scecli2:latest

cd /root/scloudv159EdgwareSR1V2/demo-eureka-client3/
docker build -t scecli3 .
docker tag scecli3 awsazuser/scecli3:latest
docker push awsazuser/scecli3:latest
