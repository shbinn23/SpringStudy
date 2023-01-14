package study.hong.member;

public interface MemberService {

    void join(Member member);   // Member 클래스를 타입으로 하는 변수 member [회원 가입]

    Member findMember(Long memberId);   // [회원 찾기]
}
