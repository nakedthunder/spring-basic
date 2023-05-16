package hello.core.member;

public class MemberServiceImpl implements MemberService{

    // 가입을 하고 회원을 찾을라면 memberRepo가 필요하다.
    // 구현객체를 선택해줘야함
    // command + shift + enter 자동완성
    private final MemberRespository memberRespository;

    // 생성자 생성
    public MemberServiceImpl(MemberRespository memberRespository) {
        this.memberRespository = memberRespository;
    }

    @Override
    public void join(Member member) {
        // 다형성에 의해서 MemoryMemberRepository있는 오버라이드한 save가 호출이된다.
        memberRespository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        //
        return memberRespository.findById(memberId);
    }
}
