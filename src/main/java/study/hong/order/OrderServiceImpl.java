package study.hong.order;

import study.hong.discount.DiscountPolicy;
import study.hong.discount.FixDiscountPolicy;
import study.hong.discount.RateDiscountPolicy;
import study.hong.member.Member;
import study.hong.member.MemberRepository;
import study.hong.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository; /*= new MemoryMemberRepository();*/     // MemberRepository 인터페이스를 구현한 MemoryMemberRepository 클래스의 객체 생성
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();      // DiscountPolicy 인터페이스를 구현한 FixDiscountPolicy 클래스의 객체 생성
    private final DiscountPolicy discountPolicy; /*= new RateDiscountPolicy();*/     // // DiscountPolicy 인터페이스를 구현한 RateDiscountPolicy 클래스의 객체 생성
    //  할인 정책을 변경하려면 DiscountPolicy 인터페이스(추상)를 구현한 구현 클래스를 바꿔줘야한다 (MemoryMemberRepository=>RateDiscountPolicy)
    //  dip 위반이기때문에 impl 클래스는 인터페이스에만 의존하도록 코드를 수정해야한다.

    // new MemoryMemberRepository(); , new RateDiscountPolicy(); 를 AppConfig에서 구현하고 밑의 생성자를 통해 주입받는다.
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    // 주문이 생성되면, 회원정보를 조회하고 할인 정책을 적용하여 그 객체를 Order 클래스 타입으로 반환한다.
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice); // git testㅇㅇ
    }
}
