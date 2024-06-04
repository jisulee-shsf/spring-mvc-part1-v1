package study.springmvcpart1.web.frontcontroller.v4;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import study.springmvcpart1.web.frontcontroller.MyView;
import study.springmvcpart1.web.frontcontroller.v4.controller.MemberFormControllerV4;
import study.springmvcpart1.web.frontcontroller.v4.controller.MemberListControllerV4;
import study.springmvcpart1.web.frontcontroller.v4.controller.MemberSaveControllerV4;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServletV4", urlPatterns = "/front-controller/v4/*")
public class FrontControllerServletV4 extends HttpServlet {

    Map<String, ControllerV4> collectionMap = new HashMap<>();

    public FrontControllerServletV4() {
        collectionMap.put("/front-controller/v4/members/new-form", new MemberFormControllerV4());
        collectionMap.put("/front-controller/v4/members/save", new MemberSaveControllerV4());
        collectionMap.put("/front-controller/v4/members", new MemberListControllerV4());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        ControllerV4 controller = collectionMap.get(requestURI);
        if (controller == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        } else {
            Map<String, String> parameterMap = createParameterMap(request);
            Map<String, Object> model = new HashMap<>();
            String viewName = controller.process(parameterMap, model);

            MyView myView = viewResolver(viewName);
            myView.render(request, response, model);
        }
    }

    private MyView viewResolver(String viewName) {
        return new MyView("/WEB-INF/views/" + viewName + ".jsp");
    }

    private Map<String, String> createParameterMap(HttpServletRequest request) {
        Map<String, String> parameterMap = new HashMap<>();
        request.getParameterNames().asIterator()
                .forEachRemaining(parameterName -> parameterMap.put(parameterName, request.getParameter(parameterName)));
        return parameterMap;
    }
}
