package study.springmvcpart1.web.frontcontroller.v4.controller;

import study.springmvcpart1.domain.Member;
import study.springmvcpart1.domain.MemberRepository;
import study.springmvcpart1.web.frontcontroller.v4.ControllerV4;

import java.util.Map;

public class MemberSaveControllerV4 implements ControllerV4 {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public String process(Map<String, String> parameterMap, Map<String, Object> model) {
        String username = parameterMap.get("username");
        int age = Integer.parseInt(parameterMap.get("age"));

        Member member = new Member(username, age);
        memberRepository.save(member);

        model.put("member", member);
        return "save-result";
    }
}
