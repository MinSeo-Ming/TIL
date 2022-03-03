package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();


    @Override
    public Order crateOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId); //먼저 조회
        int discountPrice = discountPolicy.discount(member, itemPrice); // order에선 난 몰라 discountPolicy에서 알아서 해줘 라고 하면 되니까...

        return new Order(memberId, itemName,itemPrice,discountPrice);//최종 생성된 주문

    }
}
