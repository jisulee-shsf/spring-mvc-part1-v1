package study.springmvcpart1.web.frontcontroller.v5.adapter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import study.springmvcpart1.web.frontcontroller.ModelView;
import study.springmvcpart1.web.frontcontroller.v3.ControllerV3;
import study.springmvcpart1.web.frontcontroller.v5.MyHandlerAdapter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ControllerV3HandlerAdapter implements MyHandlerAdapter {

    @Override
    public boolean suports(Object handler) {
        return (handler instanceof ControllerV3);
    }

    @Override
    public ModelView handler(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException {
        ControllerV3 controller = (ControllerV3) handler;

        Map<String, String> parameterMap = createParameterMap(request);
        ModelView modelView = controller.process(parameterMap);
        return modelView;
    }

    private Map<String, String> createParameterMap(HttpServletRequest request) {
        Map<String, String> parameterMap = new HashMap<>();
        request.getParameterNames().asIterator()
                .forEachRemaining(parameterName -> parameterMap.put(parameterName, request.getParameter(parameterName)));
        return parameterMap;
    }
}
