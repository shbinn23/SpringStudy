package study.hong.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import study.hong.AppConfig;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    AppConfig appConfig = new AppConfig();
    MemberService memberService = appConfig.memberService();
//    MemberService memberService = new MemberServiceImpl();
    @Test
    void join() {

        //given
        Member member = new Member(1L, "hongbin", Grade.VIP);

        //when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //then
        Assertions.assertThat(member).isEqualTo(findMember);


    }
}