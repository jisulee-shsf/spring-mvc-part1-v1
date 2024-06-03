package study.springmvcpart1.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void save() {
        //given
        Member member = new Member("A", 10);

        //when
        Member saveMember = memberRepository.save(member);

        //then
        Member findMember = memberRepository.findById(member.getId());
        assertThat(saveMember).isEqualTo(findMember);
    }

    @Test
    void findAllMembers() {
        //given
        Member member1 = new Member("A", 10);
        Member member2 = new Member("B", 20);

        memberRepository.save(member1);
        memberRepository.save(member2);

        //when
        List<Member> allMembers = memberRepository.findAllMembers();

        //then
        assertThat(allMembers.size()).isEqualTo(2);
        assertThat(allMembers).contains(member1, member2);
    }
}