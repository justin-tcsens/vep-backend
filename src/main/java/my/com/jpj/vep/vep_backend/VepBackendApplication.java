package my.com.jpj.vep.vep_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
		//(scanBasePackages={"my.com.jpj.vep.vep_model", "com.jpj.vep.vep_model"})
@ComponentScan(basePackages = {"my.com.jpj.vep.vep_backend","my.com.jpj.vep.vep_model", "com.jpj.vep.vep_model"})
public class VepBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(VepBackendApplication.class, args);
	}

}
