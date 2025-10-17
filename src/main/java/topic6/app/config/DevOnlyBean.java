package topic6.app.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("dev")
public class DevOnlyBean {
    private static final Logger log = LoggerFactory.getLogger(DevOnlyBean.class);

    public DevOnlyBean() {
        log.info("✅ DevOnlyBean активовано (тільки у профілі dev)");
    }
}
