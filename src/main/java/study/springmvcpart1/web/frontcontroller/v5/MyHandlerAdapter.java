package study.springmvcpart1.web.frontcontroller.v5;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import study.springmvcpart1.web.frontcontroller.ModelView;

import java.io.IOException;

public interface MyHandlerAdapter {

    boolean suports(Object handler);

    ModelView handler(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException;
}
