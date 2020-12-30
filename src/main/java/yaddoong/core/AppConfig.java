package yaddoong.core;

import yaddoong.core.discount.DiscountPolicy;
import yaddoong.core.discount.FixDiscountPolicy;
import yaddoong.core.member.MemberRepository;
import yaddoong.core.member.MemberService;
import yaddoong.core.member.MemberServiceImpl;
import yaddoong.core.member.MemoryMemberRepository;
import yaddoong.core.order.OrderService;
import yaddoong.core.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(
                memberRepository(),
                discountPolicy());
    }

    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }

}
