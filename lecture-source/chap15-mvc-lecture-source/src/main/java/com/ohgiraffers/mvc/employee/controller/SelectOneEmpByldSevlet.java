package com.ohgiraffers.mvc.employee.controller;

import com.ohgiraffers.mvc.employee.model.dto.EmployeeDTO;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.io.IOException;
@WebServlet("/employee/select")
public class SelectOneEmpByldSevlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String empId = request.getParameter("empId");
        System.out.println("empId : " + empId);

        EmployeeService employeeService = new EmployeeService();
        EmployeeDTO selectedEmp = employeeService.selectOneEmpById(empId);
        System.out.println("selectedEmp : "+selectedEmp);

        String path = " ";
        if (selectedEmp != null){
            path = "/WEB-INF/views/employee/selectedEmp.jsp";
            request.setAttribute("selectedEmp",selectedEmp );
        }else {
            path = "/WEB-INF/views/common/errorPage.jsp";
            request.setAttribute("message", "해당 사번을 가진 직원은... 없습니다!");
        }

        request.getRequestDispatcher(path).forward(request,response);

    }
}
