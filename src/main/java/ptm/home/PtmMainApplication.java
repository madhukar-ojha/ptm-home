package ptm.home;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@EnableWebSecurity
@EnableTransactionManagement
@EnableAspectJAutoProxy
@EnableDiscoveryClient
@EnableFeignClients
@ServletComponentScan(value = "ptm.home.listener")
//@SpringBootApplication(scanBasePackages = {"ptm.home", "ptm.common"})
@SpringBootApplication(scanBasePackages = {"ptm.home", "ptm.common"})
public class PtmMainApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(PtmMainApplication.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(PtmMainApplication.class);
	}

}
