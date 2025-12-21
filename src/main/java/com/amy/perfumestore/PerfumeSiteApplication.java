
//package com.amy.perfumestore;
//
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//@SpringBootApplication
//
//
//public class PerfumeSiteApplication {
//
//    public static void main(String[] args) {
//        SpringApplication.run(PerfumeSiteApplication.class, args);
//    }
//}

package com.amy.perfumestore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })




public class PerfumeSiteApplication {
    public static void main(String[] args) {
        SpringApplication.run(PerfumeSiteApplication.class, args);
    }


}