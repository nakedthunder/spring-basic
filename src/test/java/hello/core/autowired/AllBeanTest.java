package hello.core.autowired;

import hello.core.AutoAppConfig;
import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Map;

public class AllBeanTest {

    @Test
    void findAllBean() {
        // 스프링 컨테이너를 등럭하면서
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class, DiscountService.class);

        DiscountService bean = ac.getBean(DiscountService.class);

    }

    // 새로운 서비스 생성
    static class DiscountService {
        //Map으로 String, DiscountPolicy 를 다 받는다.
        private final Map<String, DiscountPolicy> policyMap;
        // list는 테스트로 만들어봄
        private final List<DiscountPolicy> policies;

        @Autowired
        private DiscountService(Map<String, DiscountPolicy> policyMap, List<DiscountPolicy> policies) {
            this.policyMap = policyMap;
            this.policies = policies;
            System.out.println("policyMap= " + policyMap);
            System.out.println("policies= "+ policies);
        }

        // 생성자 주입

    }
}
