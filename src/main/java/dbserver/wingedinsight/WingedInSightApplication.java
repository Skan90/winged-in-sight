package dbserver.wingedinsight;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class WingedInSightApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
		return application.sources(WingedInSightApplication.class).headless(false);
	}

	public static void main(String[] args) {
		SpringApplication.run(WingedInSightApplication.class, args);
	}

}
