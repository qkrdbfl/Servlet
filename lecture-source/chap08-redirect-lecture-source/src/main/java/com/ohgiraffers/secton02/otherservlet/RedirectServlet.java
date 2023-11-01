package com.ohgiraffers.secton02.otherservlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/redirect")
public class RedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        System.out.println("이 서블릿으로 redirect 성공");

//문자열을 이용해 사용자에게 내보낼 페이지를 작성한다
        StringBuilder responseBuilder = new StringBuilder();
        responseBuilder.append("<!doctype htm>\n")
                .append("<html>\n")
                .append("<head>\n")
                .append("</head>\n")
                .append("<body>\n")
                .append("<h1>이 서블릿으로 redirect 성공</h1>")
                .append("</body>\n")
                .append("</html>");

        response.setContentType("text/html; charset=UTF-8");

        PrintWriter out = response.getWriter();
        out.print(responseBuilder.toString());
        out.close();

    }
}
