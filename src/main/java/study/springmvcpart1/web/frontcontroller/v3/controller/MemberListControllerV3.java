package study.springmvcpart1.web.frontcontroller.v3.controller;

import study.springmvcpart1.domain.Member;
import study.springmvcpart1.domain.MemberRepository;
import study.springmvcpart1.web.frontcontroller.ModelView;
import study.springmvcpart1.web.frontcontroller.v3.ControllerV3;

import java.util.List;
import java.util.Map;

public class MemberListControllerV3 implements ControllerV3 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public ModelView process(Map<String, String> parameterMap) {
        List<Member> members = memberRepository.findAllMembers();

        ModelView modelView = new ModelView("members");
        modelView.getModel().put("members", members);
        return modelView;
    }
}
