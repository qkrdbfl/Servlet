package com.ohgiraffers.section01.othersite;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/othersite")
public class OthersiteRedirect extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("get 요청후 naver 사이트로 redirect");

        response.sendRedirect("https://www.naver.com");
    }
}
