package hello.core.beanFind;

import hello.core.member.MemberRespository;
import hello.core.member.MemoryMemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationContextSameBeanFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SameBeanConfig.class);

    // 예외를 터지는게 성공로직
    @Test
    @DisplayName("타입으로 조회시 같은 타입이 둘 이상 있으면, 중복 오류가 발생한다.")
    void findBeanByTypeDuplicate() {
        // 예외: NoUniqueBeanDefinitionException
        //MemberRespository bean = ac.getBean(MemberRespository.class);
        assertThrows(NoUniqueBeanDefinitionException.class,
                () -> ac.getBean(MemberRespository.class));
    }

    @Test
    @DisplayName("특정 타입을 모두 조회하기")
    void findAllBeanByType() {
        // Map으로 출력된다. key, value
        Map<String, MemberRespository> beansOfType = ac.getBeansOfType(MemberRespository.class);
        for (String s : beansOfType.keySet()) {
            System.out.println("key = " + s + " value = " + beansOfType);
            assertThat(beansOfType.size()).isEqualTo(2);
        }
    }

    @Configuration
    static class SameBeanConfig {
        //static 클래스를 사용한다는 것은 이 클래스 안에서만 사용하겠다는 의미

        @Bean
        public MemberRespository memberRespository1() {
            return new MemoryMemberRepository();
        }

        @Bean
        public MemberRespository memberRespository2() {
            return new MemoryMemberRepository();
        }

    }
}
