package study.springmvcpart1.web.frontcontroller.v3;

import study.springmvcpart1.web.frontcontroller.ModelView;

import java.util.Map;

public interface ControllerV3 {

    ModelView process(Map<String, String> parameterMap);
}
