package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {
    MemberService memberService;
    //테스트를 실행하기 전에 무조건 AppConfig를 만들고 그다음에 할당을 하고 테스트가 돌아감
    // 테스트가 2개이면 두번돔
    @BeforeEach
    public void beforEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    void join() {
        // given 주어짐
        // new Member()를 생성자로 접근;;
        Member member = new Member(1L, "memberA", Grade.VIP);

        // when 언제 (찾아서)
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        // then 된다 (검증)
        // org.assertj.core.api
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
