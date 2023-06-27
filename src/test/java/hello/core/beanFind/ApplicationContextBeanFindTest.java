package hello.core.beanFind;

import hello.core.member.Member;
import hello.core.member.MemberRespository;
import hello.core.member.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationContextBeanFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SameBeanConfig.class);


    @Test
    @DisplayName("타입으로 조회시 같은 타입이 둘 이상 있으면, 중복오류가 발생")
    void findBeanTypeDuplicate() {
        // 타입만 지정했을 경우 터지는 오류확인하기 (예외를 터지는게 성공하는 test)
        assertThrows(NoUniqueBeanDefinitionException.class,
                () -> ac.getBean(MemberRespository.class));
    }

    @Test
    @DisplayName("타입으로 조회시 같은 타입이 둘 이상 있으면, 빈 이름을 지정하면 된다.")
    void findBeanByName() {
        MemberRespository memberRespository = ac.getBean("memberRepository1", MemberRespository.class);
        assertThat(memberRespository).isInstanceOf(MemberRespository.class);
    }

    // 둘다 꺼내고 싶을때
    @Test
    @DisplayName("특정 타입을 모두 조회하기") // command + shift + enter
    void findAllBeanByType() {
        //command + option + v
        Map<String, MemberRespository> beansOfType = ac.getBeansOfType(MemberRespository.class);
        for (String key : beansOfType.keySet()) {
            System.out.println("key = " + key + "value = " + beansOfType.get(key));
        }
        System.out.println("빈즈 오브 타입 = " + beansOfType);
        assertThat(beansOfType.size()).isEqualTo(2);
    }

    // static 클래스 안에 static 을 사용한거는 여기서만 사용하겠다. 스코프를 지정
    @Configuration
    static class SameBeanConfig {
        @Bean
        public MemberRespository memberRepository1() {
            return new MemoryMemberRepository();
        }

        @Bean
        public MemberRespository memberRepository2() {
            return new MemoryMemberRepository();
        }
    }
}
