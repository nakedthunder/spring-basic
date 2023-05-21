package hello.core;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
       /* 자바코드로 appConfig에 접근했다면 아래 스프링으로 변환
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        */

        /*
        * ApplicationContext
        *
        * AnnotationConfigApplicationContext
        *
        * getBean
        * */
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        // command option v (window control+alt+v)
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);
        // 순수한 자바코드로 테스트 -> 좋은 Junit 테스트 프레임워크를 쓰자
        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("findMember = " + findMember.getName());
    }
}
