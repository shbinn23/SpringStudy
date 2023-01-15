package study.hong;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import study.hong.discount.DiscountPolicy;
import study.hong.discount.FixDiscountPolicy;
import study.hong.discount.RateDiscountPolicy;
import study.hong.member.MemberRepository;
import study.hong.member.MemberService;
import study.hong.member.MemberServiceImpl;
import study.hong.member.MemoryMemberRepository;
import study.hong.order.OrderService;
import study.hong.order.OrderServiceImpl;

@Configuration
public class AppConfig {

    @Bean
    // MemberService 인터페이스가 리턴타입인 memberService 메서드 작성
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(
                memberRepository(),
                discountPolicy());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }


}
