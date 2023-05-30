package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRespository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService{

    // 기존의 인터페이스, 구현체를 수정한다. 여기서는 memberRepository, discountPolicy를 사용
    // 1. 구현체를 지운다.
    // 2. 생성자를 만들어준다.
    // tip: final로 되어있으면, 생성자로 할당이 된다.
    private final MemberRespository memberRespository;
    private final DiscountPolicy discountPolicy;

    @Autowired
    // 생성자를 통해 구현체를 넣어줌
    public OrderServiceImpl(MemberRespository memberRespository, DiscountPolicy discountPolicy) {
        this.memberRespository = memberRespository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        // 할인 하는거에 member를 넘김 (단일체계원칙 잘 지킴)
        Member member = memberRespository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice); // 단일체계원칙

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }


}
