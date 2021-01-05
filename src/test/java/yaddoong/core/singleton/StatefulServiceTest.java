package yaddoong.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.assertj.core.api.Assertions.assertThat;

public class StatefulServiceTest {
    @Test
    void statefulServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefullService statefullService1 = ac.getBean(StatefullService.class);
        StatefullService statefullService2 = ac.getBean(StatefullService.class);

        //ThreadA: A 사용자 10000원 주문
        int userA = statefullService1.order("userA", 10000);
        //ThreadB: B 사용자 20000원 주문
        int userB = statefullService2.order("userB", 20000);

        //ThreadA: 사용자A 주문 금액을 조회
//        int price = statefullService1.getPrice();
        System.out.println("price = " + userA);

        assertThat(userA).isEqualTo(10000);
    }

    static class TestConfig {
        @Bean
        public StatefullService statefullService() {
            return new StatefullService();
        }
    }
}
