package study.hong.member;

import java.util.Map;

public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository; /*= new MemoryMemberRepository();*/
    // 객체 타입 : MemberRepository, 객체명 : memberRepository, 객체 구현체 : MemoryMemberRepository

    //new MemoryMemberRepository(); 를 AppConfig에서 주입하면 밑의 생성자를 통해 받는다.
    public MemberServiceImpl(MemberRepository memberRepository) {

        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);  // Member 클래스에 매핑된 정보를 저장하는 구현체
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId); // 파라미터 memberId로 findById 메서드 호출하여 Member 타입으로 리턴
    }


}
