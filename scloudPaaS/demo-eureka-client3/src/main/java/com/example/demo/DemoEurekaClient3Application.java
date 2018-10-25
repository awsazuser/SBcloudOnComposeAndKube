package com.example.demo;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.util.Date;

@EnableDiscoveryClient
@SpringBootApplication
@RestController
public class DemoEurekaClient3Application implements CommandLineRunner{
	@Autowired
    private mongoRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(DemoEurekaClient3Application.class, args);
    }


    @RestController
    class ServiceInstanceRestController {

	@RequestMapping("/")
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
            return "Container ID   :  "+hostname + "-----Java Version is :"+ System.getProperty("java.version");

		
    }
    }

     public void run(String... arg0) throws Exception {
        InetAddress ip1 = null;
        String hostname1;
        String message;
        
        try {
			ip1 = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Date date = new Date();
        hostname1 = ip1.getHostName();

        message = "Date : "+ date.toString() +"Java info : " + System.getProperty("java.version");
        
		// TODO Auto-generated method stub
		repository.save(new mongo(hostname1 , message));
}
}
