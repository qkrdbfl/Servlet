package com.ohgiraffers.section02.uses;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.io.IOException;

@WebServlet("/member/regist")
public class RegistMemberServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //post 전송시 한글 깨짐 현상, 비밀번호 암호화 처리 (필터쪽에서 공통적으로 처리하면 좋음)
        //=> 각각의 서블릿에 코드를 작성할수 있지만 서블릿 요청전 filter를 통해 공통적으로 처리하면
        //보다 효율족으로 처리가능하고 변경시에도 쉽게 변경 가능
        //=> 인코딩 필터와 암호화 필터를 추가한다

        String userId = request.getParameter("userId");
        String password = request.getParameter("password");
        String name = request.getParameter("name");

        System.out.println("userId : " + userId);
        System.out.println("password : " + password);
        System.out.println("name : " + name);

        //암호화 된 패스워드는 동일 값이 입력 되더라도 매번 실행 시 마다 다른 값을 가지게 된다
        //나중에 DB에 이 상태로 기록하면 로그인 시 비밀번호가 같은지 여부를 어떻게 비교할까?
        //해당 라이브러리의 matches 라는 메소드를 이용해서 확인한다!

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println("비밀번호가 pass01 인지 확인 : " + passwordEncoder.matches("pass01", password));
        System.out.println("비밀번호가 pass02 인지 확인 : " + passwordEncoder.matches("pass02", password));
    }
}
