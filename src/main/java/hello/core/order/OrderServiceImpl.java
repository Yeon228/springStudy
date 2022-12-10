package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService{

    //@Autowired private final MemberRepository memberRepository; 필드 의존관계 자동 주입
    //외부에서 변경이 힘들어 추천 x>

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    //setter(수정자) 의존관계 주입
    //빈 등록 이후 주입함
    //선택적 의존관계 주입
    //    @Autowired
    //    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
    //        this.discountPolicy = discountPolicy;
    //    }

    //생성자 의존관계 주입
    //불변, 필수 의존관계에 사용
    //생성자가 1개만 있으면 @Autowired 없이도 자동 주입됨.
    //bean 등록과 함께 의존관계 주입. new OrderServiceImpl()시점에 주입됨
    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member,itemPrice);


        return new Order(memberId,itemName,itemPrice,discountPrice);
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }

}
