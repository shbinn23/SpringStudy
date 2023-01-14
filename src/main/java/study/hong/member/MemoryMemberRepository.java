package study.hong.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository{


    private static Map<Long, Member> store = new HashMap<>(); // 넘어온 파라미터를 map 객체에 담는다.

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);  // id를 읽어와서 member 클래스에 매핑시킨다.
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId); // memberId를 읽어와서 리턴(Member 타입)
    }
}
