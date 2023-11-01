package com.ohgiraffers.mvc.employee.controller;

import com.ohgiraffers.mvc.employee.model.dto.EmployeeDTO;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.io.IOException;
import java.util.Date;

import static java.util.Date.*;

@WebServlet("/employee/insert")
public class insertEmpServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String empName = request.getParameter("empName");
        String empNo = request.getParameter("empNo");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String deptCode = request.getParameter("deptCode");
        String jobCode = request.getParameter("jobCode");
        String salLevel = request.getParameter("salLevel");
        int salary = Integer.parseInt(request.getParameter("salary"));
        double bonus = Double.parseDouble(request.getParameter("bonus"));
        String managerId = request.getParameter("managerId");
        Date hireDate = java.sql.Date.valueOf(request.getParameter("hireDate"));

        EmployeeDTO emp = new EmployeeDTO();
        emp.setEmpName(empName);
        emp.setEmpNo(empNo);
        emp.setEmail(email);
        emp.setPhone(phone);
        emp.setDeptCode(deptCode);
        emp.setJobCode(jobCode);
        emp.setSalLevel(salLevel);
        emp.setSalary(salary);
        emp.setBonus(bonus);
        emp.setManagerId(managerId);
        emp.setHireDate(hireDate);

        System.out.println("insert request emp : " + emp);

        EmployeeService employeeService = new EmployeeService();
        int result = employeeService.insertEmp(emp);

        if (result >0){
            //insert사 성공했을 경우 요청 url이 그대로 남아 잇다면 새로고침 시 다시 insert 를 요청하게 ㅎ되는 문제가 잇으,ㅁ
            //따라서 redirect 처리가 필요함
            response.sendRedirect(request.getContextPath()+ "/employee/list");
        }else {
            request.setAttribute("message", "신규 직원 등록에 실패하였습니당");
            request.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(request,response);

        }
    }
}
