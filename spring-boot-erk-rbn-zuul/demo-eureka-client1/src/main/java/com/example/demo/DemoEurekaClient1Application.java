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
public class DemoEurekaClient1Application {

    public static void main(String[] args) {
        SpringApplication.run(DemoEurekaClient1Application.class, args);
    }


    @RestController
    class ServiceInstanceRestController {

	@RequestMapping("/osinfo")
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
            return "Container ID:"+hostname +" --OS info :"+ System.getProperty("os.name")+"--"+ System.getProperty("os.version")+"--"+ System.getProperty("os.arch");
		
    }
    }

}
