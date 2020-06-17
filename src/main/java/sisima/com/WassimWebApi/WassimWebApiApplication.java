package sisima.com.WassimWebApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages="sisima.com.WassimWebApi.*")
@EnableJpaRepositories(basePackages="sisima.com.WassimWebApi.*")
public class WassimWebApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(WassimWebApiApplication.class, args);
	}

}
