package yaddoong.core.order;

import yaddoong.core.discount.DiscountPolicy;
import yaddoong.core.discount.FixDiscountPolicy;
import yaddoong.core.member.Member;
import yaddoong.core.member.MemberRepository;
import yaddoong.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
