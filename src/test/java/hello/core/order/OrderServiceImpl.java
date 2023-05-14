package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRespository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    // 구현체: MemberRespository, DiscountPolicy
    private final MemberRespository memberRespository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        // 할인 하는거에 member를 넘김 (단일체계원칙 잘 지킴)
        Member member = memberRespository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice); // 단일체계원칙

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }


}
