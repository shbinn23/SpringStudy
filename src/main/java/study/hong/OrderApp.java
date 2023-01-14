package study.hong;

import study.hong.member.Grade;
import study.hong.member.Member;
import study.hong.member.MemberService;
import study.hong.member.MemberServiceImpl;
import study.hong.order.Order;
import study.hong.order.OrderService;
import study.hong.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();  // 1. 회원정보 조회하여
        OrderService orderService = new OrderServiceImpl();   // 2. 할인정책 적용하여 주문

        long memberId = 1L;     // 멤버 ID  선언
        Member member = new Member(memberId, "hongbin", Grade.VIP);     // 생성자 파라미터에 회원정보 세팅하여 객체 생성
        memberService.join(member);     // 세팅된 회원정보로 join 메서드 호출

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order =" + order);
    }
}
