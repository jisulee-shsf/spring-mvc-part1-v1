package study.springmvcpart1.web.frontcontroller.v2.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import study.springmvcpart1.domain.Member;
import study.springmvcpart1.domain.MemberRepository;
import study.springmvcpart1.web.frontcontroller.MyView;
import study.springmvcpart1.web.frontcontroller.v2.ControllerV2;

import java.io.IOException;
import java.util.List;

public class MemberListControllerV2 implements ControllerV2 {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Member> members = memberRepository.findAllMembers();

        request.setAttribute("members", members);
        return new MyView("/WEB-INF/views/members.jsp");
    }
}
