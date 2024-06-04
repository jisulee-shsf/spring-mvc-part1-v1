package study.springmvcpart1.web.frontcontroller.v4;

import java.util.Map;

public interface ControllerV4 {

    String process(Map<String, String> parameterMap, Map<String, Object> model);
}
