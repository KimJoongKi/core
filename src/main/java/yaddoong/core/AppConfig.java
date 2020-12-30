package yaddoong.core;

import yaddoong.core.discount.FixDiscountPolicy;
import yaddoong.core.member.MemberService;
import yaddoong.core.member.MemberServiceImpl;
import yaddoong.core.member.MemoryMemberRepository;
import yaddoong.core.order.OrderService;
import yaddoong.core.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(
                new MemoryMemberRepository(),
                new FixDiscountPolicy());
    }

}
