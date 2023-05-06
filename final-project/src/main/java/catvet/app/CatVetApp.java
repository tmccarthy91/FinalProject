package catvet.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import catvet.ComponentScanMarker;


@SpringBootApplication(scanBasePackageClasses = {ComponentScanMarker.class })
public class CatVetApp {
	public static void main(String[] args) {
		SpringApplication.run(CatVetApp.class, args);

	}
}