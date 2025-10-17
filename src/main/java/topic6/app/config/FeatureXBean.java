package topic6.app.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(
        name = "feature.x.enabled",
        havingValue = "true",
        matchIfMissing = false
)
public class FeatureXBean {
    private static final Logger log = LoggerFactory.getLogger(FeatureXBean.class);

    public FeatureXBean() {
        log.info("🧩 Feature X увімкнено (feature.x.enabled=true)");
    }
}
