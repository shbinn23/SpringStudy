package study.hong.member;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import study.hong.AppConfig;

public class MemberApp {
    public static void main(String[] args) {

//        AppConfig appConfig = new AppConfig();

//        MemberService memberService = appConfig.memberService();
//        MemberService memberService = new MemberServiceImpl();

        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = ac.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "hongbin", Grade.VIP);   // 파라미터(회원정보)를 넣어 객체 생성
        memberService.join(member);     // 위에서 파라미터를 넣어 회원정보를 하나 생성하였으니, join 메서드를 이용하여 저장한다.

        Member findMember = memberService.findMember(1L);   // findMember 메서드에 아이디 정보를 파라미터로 넘겨 메서드를 호출하고 받아온 값을 findMember에 저장

        System.out.println("new memeber = " + member.getName());
        System.out.println("find member = " + findMember.getName());
    }
}
