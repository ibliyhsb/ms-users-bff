package cl.duoc.ms_users_bff;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "cl.duoc.ms_users_bff.client")
public class MsUsersBffApplication {

	   public static void main(String[] args) {
		   SpringApplication.run(MsUsersBffApplication.class, args);
	   }

}
