package study.springmvcpart1.web.frontcontroller.v3.controller;

import study.springmvcpart1.web.frontcontroller.ModelView;
import study.springmvcpart1.web.frontcontroller.v3.ControllerV3;

import java.util.Map;

public class MemberFormControllerV3 implements ControllerV3 {

    @Override
    public ModelView process(Map<String, String> parameterMap) {
        return new ModelView("new-form");
    }
}
