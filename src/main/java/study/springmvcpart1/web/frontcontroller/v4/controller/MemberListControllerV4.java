package study.springmvcpart1.web.frontcontroller.v4.controller;

import study.springmvcpart1.domain.Member;
import study.springmvcpart1.domain.MemberRepository;
import study.springmvcpart1.web.frontcontroller.v4.ControllerV4;

import java.util.List;
import java.util.Map;

public class MemberListControllerV4 implements ControllerV4 {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public String process(Map<String, String> parameterMap, Map<String, Object> model) {
        List<Member> members = memberRepository.findAllMembers();

        model.put("members", members);
        return "members";
    }
}
