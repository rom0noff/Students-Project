package uz.roadmap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import uz.roadmap.document.PdfConvertor;

@SpringBootApplication
public class RoadMapApplication {

    public static void main(String[] args) {
        SpringApplication.run(RoadMapApplication.class, args);
    }

}
