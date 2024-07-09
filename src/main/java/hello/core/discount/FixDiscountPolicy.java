package hello.core.discount;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


@Component
@MainDiscountPolicy
public class FixDiscountPolicy implements DiscountPolicy{

    private int discountFixPolicy = 1000;

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP) {
            return discountFixPolicy;
        } else {
            return 0;
        }
    }

}
