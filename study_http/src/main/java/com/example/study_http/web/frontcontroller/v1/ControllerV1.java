package com.example.study_http.web.frontcontroller.v1;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface ControllerV1 {
    public void process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException;
}
