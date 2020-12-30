package yaddoong.core.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import yaddoong.core.member.Grade;
import yaddoong.core.member.Member;
import yaddoong.core.member.MemberService;
import yaddoong.core.member.MemberServiceImpl;

public class OrderServiceTest {
    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder() {
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
