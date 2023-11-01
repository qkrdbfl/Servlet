package com.ohgraffers.section02.delete;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/delete")
public class DeleteSessionDataServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        Enumeration<String> sessionNames = session.getAttributeNames();
        while (sessionNames.hasMoreElements()) {
            System.out.println(sessionNames.nextElement());
        }

        //세션의 데이터를 제거하는 방법은 여러가지가 있다
        /*
        1. 설정한 만료 시간이 지나면 세션이 만료됨
        2. removeAttribute() 로 속성을 제거함
        3. invalidate() 를 호출하면 세션의 모든 데이터 제거됨
        */

        session.removeAttribute("firstName"); //특정 정보 제거 -> removeAttribute
        sessionNames = session.getAttributeNames();
        while (sessionNames.hasMoreElements()) {
            System.out.println(sessionNames.nextElement()); //lastName만 남음
        }

        //invalidate를 호출하면 세션 자체를 무효화 했기 떄문에 이후세션을 사용하려 하면 에러 발생함
        //즉, 세션 내의 데이터를 지우는 것 뿐만 아니라 세션을 강제로 만료 시켰다고 볼수 있다
        session.invalidate(); // 모든 정보 제거 -> invalidate
        sessionNames = session.getAttributeNames();
        while (sessionNames.hasMoreElements()) {
            System.out.println(sessionNames.nextElement());
        }
    }
}
