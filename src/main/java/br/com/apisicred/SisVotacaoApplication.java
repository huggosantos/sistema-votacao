package br.com.apisicred;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication(exclude={SecurityAutoConfiguration.class})
@EnableSpringDataWebSupport
@EnableCaching
public class SisVotacaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SisVotacaoApplication.class, args);
	}

}
