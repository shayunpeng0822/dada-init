package com.dada.init;

import com.dada.base.config.util.ConfigHolder;
import com.dada.boot.autoconfigure.dadadata.EnableDadadata;
import com.dada.consul.spring.EnableConsulDiscovery;
import javax.annotation.Resource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shayunpeng
 */
@RestController
@SpringBootApplication
@EnableScheduling
@EnableConsulDiscovery()
@EnableDadadata()
public class DadaInitApplication {

  @Resource
  private ConfigHolder configHolder;

  public static void main(String[] args) {
    SpringApplication.run(DadaInitApplication.class, args);
  }

  @GetMapping("/health")
  public String health() {
    return "success";
  }

  @GetMapping("/key")
  public String createRetransferTask(String key) {
    return configHolder.getString(key, null);
  }
}