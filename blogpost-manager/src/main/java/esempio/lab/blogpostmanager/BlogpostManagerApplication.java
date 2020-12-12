package esempio.lab.blogpostmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"blogpost"})
public class BlogpostManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogpostManagerApplication.class, args);
    }

}
