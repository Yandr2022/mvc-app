package org.itstep.mvc;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEncryptableProperties
public class MvcAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MvcAppApplication.class, args);
	}

}
