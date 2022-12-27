package com.example.study_http.request;

import com.example.study_http.HelloData;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.StreamUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * http://localhost:8080/request-body-json
 *  *
 *  * JSON 형식 전송
 *  * content-type: application/json
 *  * message body: {"username": "hello", "age": 20}
 */
@WebServlet(name = "requestBodyJsonServlet", urlPatterns = "/request-body-json")
public class RequestBodyJsonServlet extends HttpServlet {

//    JSON 결과를파싱해서사용할수 있는자바 객체로변환하려면 Jackson, Gson 같은 JSON 변환
//라이브러리를추가해서 사용해야한다. 스프링부트로 Spring MVC를선택하면기본으로 Jackson
//라이브러리( ObjectMapper )를 함께제공한다.
    private ObjectMapper objectMapper = new ObjectMapper();

//     HTML form 데이터도메시지바디를 통해 전송되므로직접읽을수 있다. 하지만편리한 파리미터조회
//기능( request.getParameter(...) )을 이미 제공하기 때문에 파라미터 조회기능을 사용하면된다.
//    단 아래에 json으로 파싱은 안된다.
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletInputStream inputStream = req.getInputStream();
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

        System.out.println("messageBody = " + messageBody);

        HelloData helloData = objectMapper.readValue(messageBody, HelloData.class);

        System.out.println("helloData.username = " + helloData.getUsername());
        System.out.println("helloData.age = " + helloData.getAge());

        resp.getWriter().write("ok");
    }
}
