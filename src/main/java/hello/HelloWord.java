package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableAutoConfiguration
public class HelloWord {
    public static void main(String[] args) {
        SpringApplication.run(HelloWord.class, args);
    }

    @RequestMapping("/")
    public String hello() {
        return "hello,spring boot";
    }

}
