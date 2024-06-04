package study.springmvcpart1.web.frontcontroller.v5.adapter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import study.springmvcpart1.web.frontcontroller.ModelView;
import study.springmvcpart1.web.frontcontroller.v4.ControllerV4;
import study.springmvcpart1.web.frontcontroller.v5.MyHandlerAdapter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ControllerV4HandlerAdapter implements MyHandlerAdapter {
    @Override
    public boolean suports(Object handler) {
        return (handler instanceof ControllerV4);
    }

    @Override
    public ModelView handler(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException {
        ControllerV4 controller = (ControllerV4) handler;

        Map<String, String> parameterMap = createParameterMap(request);
        HashMap<String, Object> model = new HashMap<>();
        String viewName = controller.process(parameterMap, model);

        ModelView modelView = new ModelView(viewName);
        modelView.setModel(model);
        return modelView;
    }

    private Map<String, String> createParameterMap(HttpServletRequest request) {
        Map<String, String> parameterMap = new HashMap<>();
        request.getParameterNames().asIterator()
                .forEachRemaining(parameterName -> parameterMap.put(parameterName, request.getParameter(parameterName)));
        return parameterMap;
    }
}
