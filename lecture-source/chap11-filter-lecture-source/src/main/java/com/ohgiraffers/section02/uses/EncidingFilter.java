package com.ohgiraffers.section02.uses;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

//필터 등록을 web.xml(배포 서술자)에서 처리
public class EncidingFilter implements Filter {

    public  String encodingType;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        encodingType = filterConfig.getInitParameter("encoding-type");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //포스트 방식인지 확인 하고 싶음. 다운캐스팅으로 처리하고 인코딩 처리하기
        HttpServletRequest hrequest = (HttpServletRequest) request;
        if("POST".equals(hrequest.getMethod())){
            request.setCharacterEncoding(encodingType);
        }
        //FilterChain chain 처리
        chain.doFilter(request, response);
    }
}
