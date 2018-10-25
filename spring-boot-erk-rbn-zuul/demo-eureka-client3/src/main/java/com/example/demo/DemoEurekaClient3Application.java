package com.example.demo;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import org.springframework.data.annotation.Id;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDiscoveryClient
@SpringBootApplication
public class DemoEurekaClient3Application implements CommandLineRunner{
	@Autowired
    private mongoRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(DemoEurekaClient3Application.class, args);
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
            return "Container ID   :  "+hostname + "-----Java Version is :"+ System.getProperty("java.version")+"------OS info :"+ System.getProperty("os.name")+"--"+ System.getProperty("os.version")+"--"+ System.getProperty("os.arch");

		
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
        hostname1 = ip1.getHostName();
        Date date = new Date();
        
        message = "Date : "+ date.toString() +"Java info : " + System.getProperty("java.version")+" : OS info :"+ System.getProperty("os.name")+" : "+ System.getProperty("os.version")+" : "+ System.getProperty("os.arch");
        
		// TODO Auto-generated method stub
		repository.save(new mongo(ip1.toString() , message));
}
}
