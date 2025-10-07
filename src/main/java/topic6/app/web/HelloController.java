package topic6.app.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloController {
    private static final Logger log= LoggerFactory.getLogger(HelloController.class);

    @GetMapping("/api/hello")
    public String hello() {
        log.info("GET /api/hello called");
        return "Hello, Spring!";
    }
    @Value("${app.environment}")
    private String env;
    @GetMapping("/env")
    public String currentEnv() {
        return "Current profile: " + env;
    }
}
