package unah.lenguajes.hn.proyecto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@SpringBootApplication
public class ProyectoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoApplication.class, args);
	}

	
	@Bean
	public OpenAPI customOpenAPI(){
		return new OpenAPI()
		.info(new Info()
		.title("Delivery-APP")
		.description("IS-UNAH            --Pablo Daniel Interiano Petillo 20211030735--Cristian Alexis Ortiz Munguia                 20181032375--Angel Moises Martinez Mejia 20191002379--Gerardo Andree Salinas Aplícano          20211020592")
		.termsOfService("http://swagger.io/terms/")
		.license(new License().name("apache2.0").url("http://springdoc.org")));
	}
}
