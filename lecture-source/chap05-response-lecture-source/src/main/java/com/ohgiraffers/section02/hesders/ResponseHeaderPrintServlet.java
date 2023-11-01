package com.ohgiraffers.section02.hesders;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Iterator;

@WebServlet("/headers")
public class ResponseHeaderPrintServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html; charset=UTF-8");
        //response.setHeader("Refresh", "1"); //1초 마다 새로고침 함

        PrintWriter out = response.getWriter();

        Long currentTime = System.currentTimeMillis();

        out.print("<h1>" + currentTime + "</h1>");

        out.close();

        Collection<String> responseHeader = response.getHeaderNames();
        Iterator<String> iter = responseHeader.iterator();
        while (iter.hasNext()) {
            String headerName = iter.next();
            System.out.println(headerName + " : " + response.getHeader(headerName));
        }
    }

}
