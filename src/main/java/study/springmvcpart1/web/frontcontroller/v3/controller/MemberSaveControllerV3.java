package study.springmvcpart1.web.frontcontroller.v3.controller;

import study.springmvcpart1.domain.Member;
import study.springmvcpart1.domain.MemberRepository;
import study.springmvcpart1.web.frontcontroller.ModelView;
import study.springmvcpart1.web.frontcontroller.v3.ControllerV3;

import java.util.Map;

public class MemberSaveControllerV3 implements ControllerV3 {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public ModelView process(Map<String, String> parameterMap) {
        String username = parameterMap.get("username");
        int age = Integer.parseInt(parameterMap.get("age"));

        Member member = new Member(username, age);
        memberRepository.save(member);

        ModelView modelView = new ModelView("save-result");
        modelView.getModel().put("member", member);
        return modelView;
    }
}
