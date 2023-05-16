package hello.core;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;

public class MemberApp {
    public static void main(String[] args) {
        // 기존에 MemberServiceIml를 직접 생성했다면 ~
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        //MemberService memberService = new MemberServiceImpl();
        // command option v (window control+alt+v)
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);
        // 순수한 자바코드로만 개발...좋은 Junit 테스트 프레임워크를 쓰자
        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("findMember = " + findMember.getName());
    }
}
