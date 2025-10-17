package topic6.app.lifecycle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class SingletonBean {
    private static final Logger lod= LoggerFactory.getLogger(SingletonBean.class);

    public SingletonBean() {
        lod.info("Creating SingletonBean (hash={})",System.identityHashCode( this));
    }
}
