package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {
    RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야한다")
    void vip_o() {
         // given
        Member member = new Member(1L, "memberVIP", Grade.VIP);
        // when
        int discountPrice = rateDiscountPolicy.discount(member, 10000);

        // then
        assertThat(discountPrice).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP가 아니면 10% 할인이 되지 않아야한다.")
    void vip_x() {
         // given
        Member member = new Member(2L, "memberBASIC", Grade.BASIC);
        // when
        int discountPrice = rateDiscountPolicy.discount(member, 10000);

        // then
        assertThat(discountPrice).isEqualTo(0);
    }

}