package com.ohgirffers.section01.cookie;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/redirect")
public class RedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //redirect 시 이전 요청에 대한 정보는 존재하지 않는다. 새로운 redirect 객체다
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");

        System.out.println("firstName : " + firstName);
        System.out.println("lastName : " + lastName);

        //1. redirect에서 쿠키 목록을 쿠키 배열 형태로 꺼내온다
        //2. 쿠키의 getName과 getValue를 이용해 쿠키에 담긴 값을 사용함

        Cookie[] cookies = request.getCookies();

        for(Cookie cookie : cookies) {
            if("firstName".equals(cookie.getName())){
                firstName = cookie.getValue();
            }else if ("lastName".equals(cookie.getName())){
                lastName = cookie.getValue();
            }
        }

        //문자열을 이용해 사용자에게 내보낼 페이지를 작성한다
        StringBuilder responseBuilder = new StringBuilder();
        responseBuilder.append("<!doctype htm>\n")
                .append("<html>\n")
                .append("<head>\n")
                .append("</head>\n")
                .append("<body>\n")
                .append("<h1> yuor first name is ")
                .append(firstName)
                .append("and lastname is")
                .append(lastName)
                .append("</h1>\n")
                .append("</body>\n")
                .append("</html>");

        response.setContentType("text/html; charset=UTF-8");

        PrintWriter out = response.getWriter();
        out.print(responseBuilder.toString());
        out.close();

        //쿠키는 텍스트 파일 형태로 클라이언트 컴퓨터에 저장 됨
        //개인 pc는 크게 상관 없지만 공용 pc 등 다른 사용자와 함께 쓰는 pc면 (민감한 개인 정보를 포함하는 경우)
        //보안에 취약하다. 따라서 민감한 개인 정보를 취급하는 경우에는 쿠키보다 세션을 이용한다
        //세션은 쿠키와 유사한 형태로 key=value 쌍으로 저장되지만 서버(톰캣)에서 관리 되므로 보안에 더 우수하다는 장점이 잇다
    }
}
