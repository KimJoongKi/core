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
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        return null;
        /*return new OrderServiceImpl(
                memberRepository(),
                discountPolicy());*/
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
        //return new RateDiscountPolicy();
    }

}
