package topic6.app.lifecycle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LifecycleController {
    private static final Logger log= LoggerFactory.getLogger(LifecycleController.class);
    private final ObjectProvider<PrototypeBean> provider;

    public LifecycleController(ObjectProvider<PrototypeBean> provider) {
        this.provider= provider;
    }
    @GetMapping("/api/lifecycle/prototype")
    public String getPrototypeBean() {
        var p= provider.getObject();
        log.info("Prototype bean created (hash={})",System.identityHashCode(p));
        return "new prototype: " + System.identityHashCode(p);
    }
}
