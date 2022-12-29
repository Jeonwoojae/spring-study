package com.example.study_http.web.servletmvc;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "mvcMemberFormServlet", urlPatterns = "/servlet-mvc/members/new-form")
public class MvcMemberFormServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String viewPath = "/WEB-INF/views/new-form.jsp";
//        WEB-INF를 사용하면 외부에서 직접 jsp를 호출할 수 없다. 컨트롤러만으로 접근하도록.
        RequestDispatcher dispatcher = req.getRequestDispatcher(viewPath);
        dispatcher.forward(req,resp);
//         다른 서블릿이나 JSP로이동할 수있는기능이다. 서버내부에서다시 호출이발생한다.
//        redirect는 클라이언트에 응답이 갔다가 클라이언트가 해당 redirect로 요청한다.
//        foward는 서버 내부에서 호출하여 클라이언트가 인지하지 못한다.
    }
}
