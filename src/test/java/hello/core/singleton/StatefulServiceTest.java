package hello.core.singleton;

import org.assertj.core.api.Assertions;
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

        /**
         * 공유필드는 항상 조심해야한다.
         * 스프링 빈은 항상 무상태 stateless 로 설계하자
         */
        /*sf1.order("userA", 10000);  // thread A: A사용자가 10000을 주문
        sf2.order("userB", 20000);   // thread B: B사용자가 20000원 주문*/

        int userAPrice = sf1.order("userA", 10000);
        int userBPrice = sf2.order("userB", 20000);

        // ThreadA: 사용자 A 주문 금액 조회
        //int price = sf1.getPirce();
        System.out.println("price 금엑 = " + userAPrice);

        // A사이에 B가 들어와서 끼어와버림
        //Assertions.assertThat(sf1.getPirce()).isEqualTo(20000);

    }

    // 클래스 생성
    static class TestConfig {
        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }

}