package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.Member;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class SingletonTest {

    @Test
    @DisplayName("요청시 객체생성되는 스프링없는 순수한 DI 컨테이너")
    public void test() {
        AppConfig appConfig = new AppConfig();
        //1. 조회: 호출할 때 마다 객체를 생성
        MemberService memberService1 = appConfig.memberService();
        //2. 조회: 동일
        MemberService memberService2 = appConfig.memberService();
        //3. 참조값이 다름을 확인
        System.out.println("member1: " + memberService1);
        System.out.println("member2: " + memberService2);

        assertThat(memberService1).isNotSameAs(memberService2);
    }
    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void singletonServiceTest() {
        // 싱글톤을 getInstance로 조회: 같은 객체 인스턴스를 반환
        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();

        System.out.println("1: " + singletonService1);
        System.out.println("2: " + singletonService2);

        assertThat(singletonService1).isSameAs(singletonService2);
    }

    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void springContainer() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService mb1 = ac.getBean("memberService", MemberService.class);
        MemberService mb2 = ac.getBean("memberService", MemberService.class);

        assertThat(mb1).isSameAs(mb2);
    }

}
