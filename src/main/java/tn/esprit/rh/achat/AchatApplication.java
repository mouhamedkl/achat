package tn.esprit.rh.achat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class AchatApplication {

    public static void main(String[] args) {

//    Dotenv dotenv = Dotenv.configure().load();
//    System.out.println("DATABASE_URL: " + dotenv.get("DATABASE_URL"));
//    System.out.println("DATABASE_USERNAME: " + dotenv.get("DATABASE_USERNAME"));
//    System.out.println("DATABASE_PASSWORD: " + dotenv.get("DATABASE_PASSWORD"));
    SpringApplication.run(AchatApplication.class, args);
}

}
