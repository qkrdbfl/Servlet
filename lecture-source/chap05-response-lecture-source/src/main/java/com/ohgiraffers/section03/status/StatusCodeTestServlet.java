package com.ohgiraffers.section03.status;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.io.IOException;

@WebServlet("/status")
public class StatusCodeTestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //response.sendError(404,"없는 페이지 임다. 경로 확인해~"); //의도적으로 상태 코드를 발생
    response.sendError(500,"서버 내부 오류임. 서버 오류는 개발자 잘못이고, 이건 다 내 잘못이야..");

    }

}
