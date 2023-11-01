package com.ohgiraffers.section01.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/first/filter")
public class FirstFilterTestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("Servlet 요청 확인");

        response.setContentType("text/html; charset=UTF-8"); // 콘솔에 보이는 화면
        PrintWriter out = response.getWriter();
        out.println("<h1>필터 확인용 서블릿 요청 확인 완료 </h1>");
        out.close();
    }
}
