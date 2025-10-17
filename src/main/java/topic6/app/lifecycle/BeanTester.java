package topic6.app.lifecycle;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Component;

@Component
public class BeanTester {
    private static final Logger log= LoggerFactory.getLogger(BeanTester.class);

    private final SingletonBean singletonBean;
    private final SingletonBean singletonBean2;
    private final ObjectProvider<PrototypeBean> prototypeBeanProvider;

    public BeanTester(SingletonBean singletonBean1, SingletonBean singletonBean2,
                      ObjectProvider<PrototypeBean> prototypeBeanProvider) {
        this.singletonBean= singletonBean1;
        this.singletonBean2= singletonBean2;
        this.prototypeBeanProvider= prototypeBeanProvider;
    }

    @PostConstruct
    public void onStart(){
        log.info("Singleton same? {}", (singletonBean==singletonBean2));

        PrototypeBean prototypeBean1= prototypeBeanProvider.getObject();
        PrototypeBean prototypeBean2= prototypeBeanProvider.getObject();
        log.info("Prototype same? {}", (prototypeBean1==prototypeBean2));
    }


}
