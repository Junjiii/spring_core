package hello.core.scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import static org.assertj.core.api.Assertions.assertThat;

public class SingletonTest {

    @Test
    void singletonFindBean() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SingletonBean.class);
        SingletonBean singletonBean1 = ac.getBean(SingletonBean.class);
        SingletonBean singletonBean2 = ac.getBean(SingletonBean.class);
        System.out.println("singletonBean1 = " + singletonBean1);
        System.out.println("singletonBean2 = " + singletonBean2);

        assertThat(singletonBean1).isEqualTo(singletonBean2);

        ac.close();
    }

    @Scope
    static class SingletonBean {

        @PostConstruct
        public void init() {
            System.out.println();
            System.out.println("SingeltonBean.init");
        }

        @PreDestroy
        public void destroy() {
            System.out.println("SingeltonBean.destroy");
            System.out.println();
        }
    }
}
