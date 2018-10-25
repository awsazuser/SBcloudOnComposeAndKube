cd /root/scloudPaaS/demo-ribbon-client/
docker build -t scrbcli .
docker tag scrbcli awsazuser/scrbcli:latest
docker push awsazuser/scrbcli:latest

cd /root/scloudPaaS/demo-eureka-service
docker build -t scesrv .
docker tag  scesrv awsazuser/scesrv:latest
docker push awsazuser/scesrv:latest

cd /root/scloudPaaS/demo-zuul-gateway/
docker build -t sczuul1 .
docker tag sczuul1 awsazuser/sczuul1:latest
docker push awsazuser/sczuul1:latest

cd /root/scloudPaaS/demo-eureka-client1/
docker build -t scecli1 .
docker tag scecli1 awsazuser/scecli1:latest
docker push awsazuser/scecli1:latest

cd /root/scloudPaaS/demo-eureka-client2/
docker build -t scecli2 .
docker tag scecli2 awsazuser/scecli2:latest
docker push awsazuser/scecli2:latest

cd /root/scloudPaaS/demo-eureka-client3/
docker build -t scecli3 .
docker tag scecli3 awsazuser/scecli3:latest
docker push awsazuser/scecli3:latest
