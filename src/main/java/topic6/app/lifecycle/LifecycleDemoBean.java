package topic6.app.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.hibernate.annotations.Comment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class LifecycleDemoBean {
    private static final Logger log= LoggerFactory.getLogger(LifecycleDemoBean.class);
    public LifecycleDemoBean() {
        log.info("LifecycleDemoBean created");
    }

    @PostConstruct
    public void init() {
        log.info("LifecycleDemoBean initialized");
    }
    @PreDestroy
    public void destroy() {
        log.info("LifecycleDemoBean destroyed");
    }
}
