package topic6.app.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
@Component
@Profile("prod")
public class ProdOnlyBean {
    private static final Logger log = LoggerFactory.getLogger(ProdOnlyBean.class);

    public ProdOnlyBean() {
        log.info("🚀 ProdOnlyBean активовано (тільки у профілі prod)");
    }
}
