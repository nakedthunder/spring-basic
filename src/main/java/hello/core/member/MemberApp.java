package hello.core.member;

public class MemberApp {
    public static void main(String[] args) {
        // MemberServiceImpl.join() == save
        MemberService memberService = new MemberServiceImpl();
        // command option v (window control+alt+v)
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);
        // 순수한 자바코드로만 개발...좋은 Junit 테스트 프레임워크를 쓰자
        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("findMember = " + findMember.getName());
    }
}
