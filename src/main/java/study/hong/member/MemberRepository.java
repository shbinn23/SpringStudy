package study.hong.member;

public interface MemberRepository {

    void save(Member member); // Member 클래스를 타입으로 하는 변수 member [회원 저장]

    Member findById(Long memberId);   // [회원 찾기]
}
