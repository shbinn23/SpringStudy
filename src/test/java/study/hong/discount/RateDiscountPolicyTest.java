package study.hong.discount;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.hong.member.Grade;
import study.hong.member.Member;

public class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용")
    void vip_o() {
        // given
        Member member = new Member(1L, "hongbin", Grade.VIP);   // 생성자에 파라미터 전달하여 회원 정보를 주입
        // when
        int discount = discountPolicy.discount(member, 10000);
        // then
        Assertions.assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP가 아니면 할인 적용 X")
    void vip_x() {
        //given
        Member member = new Member(2L, "arsenal", Grade.BASIC);
        // when
        int discount = discountPolicy.discount(member, 10000);
        // then
        Assertions.assertThat(discount).isEqualTo(0);
    }
}
