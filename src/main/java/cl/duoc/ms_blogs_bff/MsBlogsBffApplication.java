package cl.duoc.ms_blogs_bff;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "cl.duoc.ms_blogs_bff.client")
public class MsBlogsBffApplication {

	   public static void main(String[] args) {
		   SpringApplication.run(MsBlogsBffApplication.class, args);
	   }

}
