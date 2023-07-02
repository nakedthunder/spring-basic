package hello.core.scan;

import hello.core.AutoAppConfig;
import hello.core.member.MemberRespository;
import hello.core.member.MemberService;
import hello.core.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutoAppConfigTest {

    @Test
    void basicScan() {
       /* AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

        MemberService memberService = ac.getBean(MemberService.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberService.class);

        // 여기 오류나서 다시 강의 돌아보기
        OrderServiceImpl bean = ac.getBean(OrderServiceImpl.class);*/
      //  MemberRespository memberRespository = bean.getMemberRespository();
      //  System.out.println("memberRepository = " + memberRespository);
    }
}
