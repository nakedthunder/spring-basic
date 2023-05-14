package hello.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    // memberService 없어서 만들어줌
    MemberService memberService = new MemberServiceImpl();

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
