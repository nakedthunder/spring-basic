package hello.core.singleton;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton() {
        //얘 하나만 생성해서 사용
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService sf1 = ac.getBean(StatefulService.class);
        StatefulService sf2 = ac.getBean(StatefulService.class);

        // 사용자 A, B가 있는데 A꺼만 구할라는데 B가 끼어드네?
        int userAPrice = sf1.order("userA", 10000);
        int userBPrice = sf2.order("userB", 20000);

        System.out.println("사용자A의 금액: " + userAPrice);
    }

    // 클래스 생성
    static class TestConfig {
        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }

}