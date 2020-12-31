package yaddoong.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import yaddoong.core.discount.DiscountPolicy;
import yaddoong.core.discount.FixDiscountPolicy;
import yaddoong.core.discount.RateDiscountPolicy;
import yaddoong.core.member.MemberRepository;
import yaddoong.core.member.MemberService;
import yaddoong.core.member.MemberServiceImpl;
import yaddoong.core.member.MemoryMemberRepository;
import yaddoong.core.order.OrderService;
import yaddoong.core.order.OrderServiceImpl;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(
                memberRepository(),
                discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
        //return new RateDiscountPolicy();
    }

}
