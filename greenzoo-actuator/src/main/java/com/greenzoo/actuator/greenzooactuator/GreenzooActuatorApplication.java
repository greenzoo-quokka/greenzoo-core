package com.greenzoo.actuator.greenzooactuator;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAdminServer  // 어노테이션 추가
@SpringBootApplication
public class GreenzooActuatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(GreenzooActuatorApplication.class, args);
    }

}
