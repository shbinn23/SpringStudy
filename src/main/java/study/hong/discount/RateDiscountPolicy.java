package study.hong.discount;

import study.hong.member.Grade;
import study.hong.member.Member;

public class RateDiscountPolicy implements DiscountPolicy{      // ctrl + o (메서드 구현)

    private int discountPercent = 10;   // 10% 할인 정책
    @Override
    public int discount(Member member, int price) {

        if (member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;   // 10% 할인
        } else {
            return 0;
        }
    }
}
