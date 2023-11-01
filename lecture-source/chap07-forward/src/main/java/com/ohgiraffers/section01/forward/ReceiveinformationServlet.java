package com.ohgiraffers.section01.forward;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.io.IOException;

@WebServlet("/forward")
public class ReceiveinformationServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String  userId = request.getParameter("userId");
        String  password = request.getParameter("password");

        System.out.println("userId : "+userId );
        System.out.println("password : "+password );

        //비즈니스 로직은 성공이라는 가정하에 입력 된 아이디를 이용해서 000님 환영합니다 하는 메세지 출력하는 화면
        // => 응답을 하기 위한 전용 서블릿을 만들고 해당 서블릿에서 응답 할수 잇도록 위임한다

        //어떤 서블릿으로 위임할 건지 대상 서블릿을 지정하는 RequestDispatcher 인스턴스를 경로로 넣어 지정하고
        //forward 메소드로 요청과 응담에 대한 정보를 전달하여 이후 작업을 수행하도록 위임한다
        request.setAttribute("userId", userId);

        RequestDispatcher rd = request.getRequestDispatcher("print");
        rd.forward(request,response);

    }
}
