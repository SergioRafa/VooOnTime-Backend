package FlightOnTimeApplication.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        // Este comando é o que liga o servidor Tomcat na porta 8080
        SpringApplication.run(Main.class, args);

        System.out.println("=========================================");
        System.out.println("   FLIGHT ON TIME - BACKEND ONLINE!      ");
        System.out.println("   Pronto para a apresentação de sexta!  ");
        System.out.println("=========================================");
    }
}