package com.example.demo;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.boot.SpringApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class DemoEurekaClient2Application {

    public static void main(String[] args) {
        SpringApplication.run(DemoEurekaClient2Application.class, args);
    }


    @RestController
    class ServiceInstanceRestController {

	@RequestMapping("/jinfo")
    public String sname() {
        InetAddress ip = null;
        String hostname;
 
            try {
				ip = InetAddress.getLocalHost();
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            hostname = ip.getHostName();
            return "Container ID:"+hostname +"--Java Version is :"+ System.getProperty("java.version");
		
    }
    }

}
