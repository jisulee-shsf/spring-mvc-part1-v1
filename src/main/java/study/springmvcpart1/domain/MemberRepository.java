package study.springmvcpart1.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    private static final MemberRepository instnace = new MemberRepository();

    public static MemberRepository getInstance() {
        return instnace;
    }

    private MemberRepository() {
    }

    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id) {
        return store.get(id);
    }

    public List<Member> findAllMembers() {
        return new ArrayList(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
