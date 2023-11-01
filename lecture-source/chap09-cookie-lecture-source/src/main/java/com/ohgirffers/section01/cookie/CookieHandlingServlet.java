package com.ohgirffers.section01.cookie;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.io.IOException;

@WebServlet("/cookie")
public class CookieHandlingServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");

        System.out.println("firstName : " + firstName);
        System.out.println("lastName : " + lastName);

        //1. 쿠기를 생성
        //2. 생성한 쿠키의 만료 시간 설정
        //3. 응답 헤더에 쿠키 담기
        //4. 응답 보내기

        //쿠키 제약 사항 *
        //이름은 ascii 문자만을 사용해야 하고 한 번 걸정한 이름 변경 불가x
        //이름에 공백문자와 일부 특수문자 ( [] () = , " \ ? @ : ; ) 사용불가

        Cookie firstNameCookie = new Cookie("firstName", firstName);
        Cookie lastNameCookie = new Cookie("lastName", lastName);

        //초 단위의 값으 ㄹ입력해서 만료 시간을 설정(하루를 만료 시간으로 하는 예시임)
        firstNameCookie.setMaxAge(60 + 60 * 24);
        lastNameCookie.setMaxAge(60 + 60 * 24);

        response.addCookie(firstNameCookie);
        response.addCookie(lastNameCookie);

        response.sendRedirect("redirect");

    }
}
