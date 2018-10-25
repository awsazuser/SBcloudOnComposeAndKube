package com.example.demo;

import org.springframework.boot.SpringApplication;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@EnableCircuitBreaker
@SpringBootApplication
@EnableDiscoveryClient
@RestController
@EnableFeignClients
@RibbonClient(name = "jinfo", configuration = DemoRibbonclientConf.class)
public class DemoRibbonClient {

  @LoadBalanced
  @Bean
  RestTemplate restTemplate(){
    return new RestTemplate();
  }

  @Autowired
  RestTemplate restTemplate;

  @RequestMapping(value="/rbncli")
  public String jver() {
           InetAddress ip = null;
           String hostname;

                  try {
                       ip = InetAddress.getLocalHost();
                       } catch (UnknownHostException e) {
                     // TODO Auto-generated catch block
                       e.printStackTrace();
                       }
          hostname = ip.getHostName();
                                                                             
          String message1 = this.restTemplate.getForObject("http://jinfo", String.class);
          String message2 = this.restTemplate.getForObject("http://osinfo", String.class);
          return String.format("Message from Ribbon client :-:-:-:-:" + hostname + ":::::" + message1 + ":::::" + message2);
  }

  @HystrixCommand(fallbackMethod = "reliable")
  @RequestMapping("reliable")
  public String reliable() {
	return "Jinfo service is currently down";
 }

  public static void main(String[] args) {
    SpringApplication.run(DemoRibbonClient.class, args);
  }
}
