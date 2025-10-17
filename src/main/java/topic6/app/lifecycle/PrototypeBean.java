package topic6.app.lifecycle;

import org.hibernate.annotations.Comment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class PrototypeBean {
    private static final Logger log= LoggerFactory.getLogger(PrototypeBean.class);

    public PrototypeBean() {
        log.info("Creating PrototypeBean (hash={})",System.identityHashCode( this));
    }
}
